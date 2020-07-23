package com.ll.admin.service.impl;

import com.ll.admin.dao.SysRoleMenuDao;
import com.ll.admin.service.SysRoleMenuService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ll.common.utils.PageUtils;
import com.ll.common.utils.Query;

import com.ll.admin.entity.SysRoleMenuEntity;


@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao, SysRoleMenuEntity> implements SysRoleMenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysRoleMenuEntity> page = this.page(
                new Query<SysRoleMenuEntity>().getPage(params),
                new QueryWrapper<SysRoleMenuEntity>()
        );

        return new PageUtils(page);
    }

}