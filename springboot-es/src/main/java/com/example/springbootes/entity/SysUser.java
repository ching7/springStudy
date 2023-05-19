package com.example.springbootes.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName SysUser
 * @Description 其实这里的实体对应的就是ES索引
 * @Document(indexName = “sys_user”) 代表映射的是sys_user 索引
 * @Field(type = FieldType.Keyword) 代表字段应设在es中是keyword类型
 * @Author ynchen
 * @Date 2023/4/6 09:51
 * @Version V1.0.0
 */
@Document(indexName = "sys_user")
public class SysUser implements Serializable {
    /**
     * ES中id不能定义为Long
     * 主键
     */
    @Id
    private String id;
    // 通过@Version注解指定版本号的属性字段
    @Version
    private Long version;
    private String username;
    private String password;
    private int level;
    @Field(type = FieldType.Keyword)
    private List<String> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
