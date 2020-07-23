package com.ll.admin.service.impl;

import com.ll.admin.dao.SysLogDao;
import com.ll.admin.service.SysLogService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ll.common.utils.PageUtils;
import com.ll.common.utils.Query;

import com.ll.admin.entity.SysLogEntity;


@Service("sysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements SysLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysLogEntity> page = this.page(
                new Query<SysLogEntity>().getPage(params),
                new QueryWrapper<SysLogEntity>()
        );

        return new PageUtils(page);
    }

}