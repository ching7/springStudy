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

import com.ll.admin.entity.SysConfigEntity;
import com.ll.admin.service.SysConfigService;
import com.ll.common.utils.PageUtils;
import com.ll.common.utils.R;



/**
 * 系统配置信息表
 *
 * @author ll
 * @email ll@qq.com
 * @date 2020-07-23 11:20:41
 */
@RestController
@RequestMapping("admin/sysconfig")
public class SysConfigController {
    @Autowired
    private SysConfigService sysConfigService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("admin:sysconfig:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysConfigService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("admin:sysconfig:info")
    public R info(@PathVariable("id") Long id){
		SysConfigEntity sysConfig = sysConfigService.getById(id);

        return R.ok().put("sysConfig", sysConfig);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("admin:sysconfig:save")
    public R save(@RequestBody SysConfigEntity sysConfig){
		sysConfigService.save(sysConfig);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("admin:sysconfig:update")
    public R update(@RequestBody SysConfigEntity sysConfig){
		sysConfigService.updateById(sysConfig);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("admin:sysconfig:delete")
    public R delete(@RequestBody Long[] ids){
		sysConfigService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
