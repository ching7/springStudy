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

import com.ll.admin.entity.SysUserRoleEntity;
import com.ll.admin.service.SysUserRoleService;
import com.ll.common.utils.PageUtils;
import com.ll.common.utils.R;



/**
 * 用户与角色对应关系
 *
 * @author ll
 * @email ll@qq.com
 * @date 2020-07-23 11:20:41
 */
@RestController
@RequestMapping("admin/sysuserrole")
public class SysUserRoleController {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("admin:sysuserrole:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = sysUserRoleService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("admin:sysuserrole:info")
    public R info(@PathVariable("id") Long id){
		SysUserRoleEntity sysUserRole = sysUserRoleService.getById(id);

        return R.ok().put("sysUserRole", sysUserRole);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("admin:sysuserrole:save")
    public R save(@RequestBody SysUserRoleEntity sysUserRole){
		sysUserRoleService.save(sysUserRole);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("admin:sysuserrole:update")
    public R update(@RequestBody SysUserRoleEntity sysUserRole){
		sysUserRoleService.updateById(sysUserRole);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("admin:sysuserrole:delete")
    public R delete(@RequestBody Long[] ids){
		sysUserRoleService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
