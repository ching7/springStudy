package com.ll.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ll.common.utils.PageUtils;
import com.ll.admin.entity.SysMenuEntity;

import java.util.Map;

/**
 * 菜单管理
 *
 * @author ll
 * @email ll@qq.com
 * @date 2020-07-23 11:20:41
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

