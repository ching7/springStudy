package com.ll.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ll.common.utils.PageUtils;
import com.ll.admin.entity.SysConfigEntity;

import java.util.Map;

/**
 * 系统配置信息表
 *
 * @author ll
 * @email ll@qq.com
 * @date 2020-07-23 11:20:41
 */
public interface SysConfigService extends IService<SysConfigEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

