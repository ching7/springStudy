package com.ll.admin.dao;

import com.ll.admin.entity.SysUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户
 * 
 * @author ll
 * @email ll@qq.com
 * @date 2020-07-23 11:20:41
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
	
}
