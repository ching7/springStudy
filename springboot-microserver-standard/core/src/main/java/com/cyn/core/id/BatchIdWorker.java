package com.cyn.core.id;

/**
 * @ClassName BatchIdWorker
 * @Description
 * @Author ynchen
 * @Date 2024/3/21 14:53
 * @Version V1.0.0
 */

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.cyn.core.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BatchIdWorker {
    private static final Logger LOGGER = LoggerFactory.getLogger(BatchIdWorker.class);

    private final long twepoch = 1577808000L;

    private long sequenceShift;

    private long timestampLeftShift;

    private long sequenceMask;

    private long workerId;

    private long sequence = 0L;

    private long lastTimestamp = -1L;

    private long lastCorrectTimestamp = -1L;

    public BatchIdWorker(long workerId, long workerIdBits, long sequenceBits) {
        this.workerId = workerId;
        this.sequenceShift = workerIdBits;
        this.timestampLeftShift = sequenceBits + workerIdBits;
        this.sequenceMask = 0xFFFFFFFFFFFFFFFFL ^ -1L << (int) sequenceBits;
        long maxWorkerId = 0xFFFFFFFFFFFFFFFFL ^ -1L << (int) workerIdBits;
        if (workerId > maxWorkerId || workerId < 0L) {
            throw new BusinessException(String.format("workerId:%d can't be greater than %d or less than 0", workerId, maxWorkerId));
        }
    }

    public synchronized long nextId() {
        long timestamp = timeGen();
        if (timestamp < this.lastTimestamp) {
            if (this.lastTimestamp < this.lastCorrectTimestamp) {
                LOGGER.error("{}", this.lastCorrectTimestamp);
            } else {
                this.lastCorrectTimestamp = this.lastTimestamp;
                LOGGER.error("{}", this.lastCorrectTimestamp);
            }
            this.sequence = this.sequenceMask >> 1L;
        }
        if (timestamp > this.lastTimestamp && timestamp <= this.lastCorrectTimestamp) {
            this.sequence = this.sequenceMask >> 1L;
        }
        if (timestamp == this.lastTimestamp) {
            this.sequence = this.sequence + 1L & this.sequenceMask;
            if (this.sequence == 0L) {
                timestamp = tilNextSeconds(this.lastTimestamp);
            }
        } else if (timestamp > this.lastCorrectTimestamp) {
            this.sequence = 0L;
        }
        this.lastTimestamp = timestamp;
        return timestamp - 1577808000L << (int) this.timestampLeftShift | this.sequence << (int) this.sequenceShift | this.workerId;
    }

    public synchronized List<Long> nextBatchIds(int size) {
        if (size <= 0) {
            throw new BusinessException("size need greater than zero");
        }
        List<Long> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(nextId());
        }
        return list;
    }

    public String parseUid(long uid) {
        long totalBits = 64L;
        long sequenceValue = uid << (int) (totalBits - this.timestampLeftShift) >>> (int) (totalBits - this.timestampLeftShift + this.sequenceShift);
        long workerIdValue = uid << (int) (totalBits - this.sequenceShift) >>> (int) (totalBits - this.sequenceShift);
        long deltaSeconds = uid >>> (int) this.timestampLeftShift;
        Date thatTime = new Date(TimeUnit.SECONDS.toMillis(1577808000L + deltaSeconds));
        String thatTimeStr = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(thatTime);
        return String.format("{\"UID\":\"%d\",\"timestamp\":\"%s\",\"workerId\":\"%d\",\"sequence\":\"%d\"}",
                uid, thatTimeStr, workerIdValue, sequenceValue);
    }

    protected long tilNextSeconds(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return Instant.now().getEpochSecond();
    }
}