package com.ll.admin.service.impl;

import com.ll.admin.dao.SysMenuDao;
import com.ll.admin.service.SysMenuService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ll.common.utils.PageUtils;
import com.ll.common.utils.Query;

import com.ll.admin.entity.SysMenuEntity;


@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysMenuEntity> page = this.page(
                new Query<SysMenuEntity>().getPage(params),
                new QueryWrapper<SysMenuEntity>()
        );

        return new PageUtils(page);
    }

}