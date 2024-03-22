package com.cyn.service;

/**
 * The interface Id service.
 *
 * @ClassName IdService
 * @Description
 * @Author ynchen
 * @Date 2024 /3/22 10:27
 * @Version V1.0.0
 */
public interface IdService {

    /**
     * Gets uid.
     *
     * @param table the table
     * @return the uid
     */
    long getUid(String table);
}
