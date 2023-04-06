package com.example.springbootes.Dao;

import com.example.springbootes.entity.SysUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName service
 * @Description
 * @Author ynchen
 * @Date 2023/4/6 10:34
 * @Version V1.0.0
 */
@Repository
public interface SysUserDao extends ElasticsearchRepository<SysUser,String> {

}
