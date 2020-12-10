package com.cyn.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chenyanan
 * Created by chenyanan on 2020/12/10
 */
@Mapper
public interface StorageDao {
    /**
     * 减库存
     *
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
