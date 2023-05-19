package com.example.springbootes.Dao;

import com.example.springbootes.entity.SysUser;
import org.elasticsearch.client.core.AcknowledgedResponse;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

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

    @Query("{\"bool\" : {\"must\" : [{\"term\" : {\"id\" : \"?0\"}}]}}")
    Optional<SysUser> findById(Serializable id);

    @Override
    void deleteById(String id);
}
