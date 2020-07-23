package com.ll.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ll.common.utils.PageUtils;
import com.ll.admin.entity.SysUserRoleEntity;

import java.util.Map;

/**
 * 用户与角色对应关系
 *
 * @author ll
 * @email ll@qq.com
 * @date 2020-07-23 11:20:41
 */
public interface SysUserRoleService extends IService<SysUserRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

