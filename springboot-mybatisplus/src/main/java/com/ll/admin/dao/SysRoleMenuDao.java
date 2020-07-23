package com.ll.admin.dao;

import com.ll.admin.entity.SysRoleMenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色与菜单对应关系
 * 
 * @author ll
 * @email ll@qq.com
 * @date 2020-07-23 11:20:41
 */
@Mapper
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenuEntity> {
	
}
