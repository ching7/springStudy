package com.cyn.core.id;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

public class SnowflakeIdGenerator {
    // 起始的时间戳（单位是毫秒）
    private final static long START_STMP = 1577808000000L; // 例如：2020年1月1日

    // 工作机器ID所占位数
    private final static long WORKER_ID_BITS = 5L;
    // 数据中心ID所占位数
    private final static long DATACENTER_ID_BITS = 5L;

    // 最大工作机器ID，结果是31 (即2^WORKER_ID_BITS - 1)
    private final static long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);
    // 最大数据中心ID，结果是31 (即2^DATACENTER_ID_BITS - 1)
    private final static long MAX_DATACENTER_ID = ~(-1L << DATACENTER_ID_BITS);

    // 序列号占用位数
    private final static long SEQUENCE_BITS = 12L;

    // 工作机器ID向左移位数
    private final static long WORKER_ID_SHIFT = SEQUENCE_BITS;
    // 数据中心ID向左移位数
    private final static long DATACENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;

    // 时间戳向左移位数
    private final static long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;

    // 生成序列号的掩码，这里为4095 (即2^SEQUENCE_BITS - 1)
    private final static long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);

    // 工作机器ID(0~31)
    private long workerId;
    // 数据中心ID(0~31)
    private long datacenterId;
    // 序列号
    private AtomicLong sequence = new AtomicLong(0L);

    // 上次生成ID的时间戳
    private long lastTimestamp = -1L;

    public SnowflakeIdGenerator(long workerId, long datacenterId) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", MAX_DATACENTER_ID));
        }

        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        // 如果当前时间小于上一次ID生成的时间戳，抛出异常（说明系统时钟回退了）
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        // 同一毫秒内，序列号自增
        if (lastTimestamp == timestamp) {
            sequence.getAndIncrement();
            // 当前序列号超出最大值时，等待下一毫秒到来
            if (sequence.get() > SEQUENCE_MASK) {
                // 阻塞到下一个毫秒，获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            // 不同毫秒内，重置序列号
            sequence.set(0L);
        }

        // 更新上次生成ID的时间戳
        lastTimestamp = timestamp;

        // ID构造逻辑：|时间戳部分|数据中心ID部分|工作机器ID部分|序列号部分|
        return ((timestamp - START_STMP) << TIMESTAMP_LEFT_SHIFT) |
                (datacenterId << DATACENTER_ID_SHIFT) |
                (workerId << WORKER_ID_SHIFT) |
                sequence.getAndIncrement();
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }
     public DecodedSnowflakeId decode(long snowflakeId) {
        long timestamp = (snowflakeId >> TIMESTAMP_LEFT_SHIFT) + START_STMP;
        long datacenterId = (snowflakeId >> DATACENTER_ID_SHIFT) & MAX_DATACENTER_ID;
        long workerId = (snowflakeId >> WORKER_ID_SHIFT) & MAX_WORKER_ID;
        long sequence = snowflakeId & SEQUENCE_MASK;

        return new DecodedSnowflakeId(timestamp, datacenterId, workerId, sequence);
    }

    // 定义一个解码后的ID对象
    @Getter
    public static class DecodedSnowflakeId {
        private final long timestamp;
        private final long datacenterId;
        private final long workerId;
        private final long sequence;

        public DecodedSnowflakeId(long timestamp, long datacenterId, long workerId, long sequence) {
            this.timestamp = timestamp;
            this.datacenterId = datacenterId;
            this.workerId = workerId;
            this.sequence = sequence;
        }

        @Override
        public String toString() {
            return "DecodedSnowflakeId{" +
                    "timestamp=" + timestamp +
                    ", datacenterId=" + datacenterId +
                    ", workerId=" + workerId +
                    ", sequence=" + sequence +
                    '}';
        }
    }
}