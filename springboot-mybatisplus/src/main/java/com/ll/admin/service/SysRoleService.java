package com.ll.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ll.common.utils.PageUtils;
import com.ll.admin.entity.SysRoleEntity;

import java.util.Map;

/**
 * 角色
 *
 * @author ll
 * @email ll@qq.com
 * @date 2020-07-23 11:20:40
 */
public interface SysRoleService extends IService<SysRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

