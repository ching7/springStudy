package com.cyn.mapper;

import org.apache.ibatis.annotations.Select;
import com.cyn.pojo.User;

import java.util.List;

public interface UserMapper {
    @Select("select a.* from  t_user a")
    List<User> selAll();
}
