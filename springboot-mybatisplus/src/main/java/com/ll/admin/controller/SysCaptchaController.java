package com.ll.admin.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ll.admin.entity.SysCaptchaEntity;
import com.ll.admin.service.SysCaptchaService;
import com.ll.common.utils.PageUtils;
import com.ll.common.utils.R;



/**
 * 系统验证码
 *
 * @author ll
 * @email ll@qq.com
 * @date 2020-07-23 11:20:41
 */
@RestController
@RequestMapping("admin/syscaptcha")
public class SysCaptchaController {
    @Autowired
    private SysCaptchaService sysCaptchaService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("admin:syscaptcha:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysCaptchaService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uuid}")
    //@RequiresPermissions("admin:syscaptcha:info")
    public R info(@PathVariable("uuid") String uuid){
		SysCaptchaEntity sysCaptcha = sysCaptchaService.getById(uuid);

        return R.ok().put("sysCaptcha", sysCaptcha);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("admin:syscaptcha:save")
    public R save(@RequestBody SysCaptchaEntity sysCaptcha){
		sysCaptchaService.save(sysCaptcha);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("admin:syscaptcha:update")
    public R update(@RequestBody SysCaptchaEntity sysCaptcha){
		sysCaptchaService.updateById(sysCaptcha);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("admin:syscaptcha:delete")
    public R delete(@RequestBody String[] uuids){
		sysCaptchaService.removeByIds(Arrays.asList(uuids));

        return R.ok();
    }

}
