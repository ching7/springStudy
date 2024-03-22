package com.cyn.service.impl;

import com.cyn.core.id.BatchUidService;
import com.cyn.service.IdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName IdServiceImpl
 * @Description
 * @Author ynchen
 * @Date 2024/3/22 10:29
 * @Version V1.0.0
 */
@Service
public class IdServiceImpl implements IdService {

    @Resource
    BatchUidService batchUidService;

    @Override
    public long getUid(String table) {
        return batchUidService.getUid(table);
    }
}
