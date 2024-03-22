package com.cyn.core.id;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;

import com.cyn.core.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @ClassName BatchUidService
 * @Description
 * @Author ynchen
 * @Date 2024/3/21 17:06
 * @Version V1.0.0
 */
public class BatchUidService {
    private static final Map<String, BatchIdWorker> tableIdWorkerCache = new ConcurrentHashMap<>();

    @Value("${coreboot.batchid.workerBits:18}")
    private Integer workerBits;

    @Value("${coreboot.batchid.seqBits:12}")
    private Integer seqBits;

    @Value("${coreboot.batchid.workId:-1}")
    private Integer workerId;

    @Autowired(required = false)
    private BatchRedisWorkIdService batchRedisWorkIdService;

    @PostConstruct
    public void postConstruct() {
        if (this.batchRedisWorkIdService != null && this.workerId < 0) {
            this.workerId = this.batchRedisWorkIdService.getWorkId();
        }
    }

    public long getUid(String table) {
        if (StringUtils.isEmpty(table)) {
            throw new BusinessException("parameter table is not empty.");
        }
        return getIdWorker(table).nextId();
    }

    public List<Long> getUid(String table, int size) {
        if (StringUtils.isEmpty(table)) {
            throw new BusinessException("parameter table is not empty.");
        }
        if (size <= 0) {
            throw new BusinessException("size need greater than zero");
        }
        return getIdWorker(table).nextBatchIds(size);
    }

    public String parseUid(String table, long uid) {
        if (StringUtils.isEmpty(table)) {
            throw new BusinessException("parameter table is not empty.");
        }
        return getIdWorker(table).parseUid(uid);
    }

    private BatchIdWorker getIdWorker(String tableTag) {
        return tableIdWorkerCache.computeIfAbsent(tableTag, k -> new BatchIdWorker(this.workerId, this.workerBits, this.seqBits));
    }
}
