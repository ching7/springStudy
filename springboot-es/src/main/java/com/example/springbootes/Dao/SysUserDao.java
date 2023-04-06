package com.example.springbootes.Dao;

import com.example.springbootes.entity.SysUser;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName service
 * @Description
 * @Author ynchen
 * @Date 2023/4/6 10:34
 * @Version V1.0.0
 */
@Repository
public interface SysUserDao extends ElasticsearchRepository<SysUser, String> {
    List<SysUser> findByUsername(String username);

    //自定义查询语句
    @Query("{\"match\":{\"username\":\"?0\"}}")
    List<SysUser> findAllByUsernameUsingAnnotations(String username);

    @Override
    Iterable<SysUser> findAll();

    @Override
    void deleteById(String id);
}
