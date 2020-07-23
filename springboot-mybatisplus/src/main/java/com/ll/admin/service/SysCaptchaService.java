package com.ll.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ll.common.utils.PageUtils;
import com.ll.admin.entity.SysCaptchaEntity;

import java.util.Map;

/**
 * 系统验证码
 *
 * @author ll
 * @email ll@qq.com
 * @date 2020-07-23 11:20:41
 */
public interface SysCaptchaService extends IService<SysCaptchaEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

