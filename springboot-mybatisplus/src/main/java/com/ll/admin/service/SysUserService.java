package com.ll.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ll.common.utils.PageUtils;
import com.ll.admin.entity.SysUserEntity;

import java.util.Map;

/**
 * 系统用户
 *
 * @author ll
 * @email ll@qq.com
 * @date 2020-07-23 11:20:41
 */
public interface SysUserService extends IService<SysUserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

