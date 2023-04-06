package com.example.springbootes.Service;

import com.example.springbootes.Dao.SysUserDao;
import com.example.springbootes.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SysUserService
 * @Description
 * @Author ynchen
 * @Date 2023/4/6 14:23
 * @Version V1.0.0
 */
@Service
public class SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 新增/修改
     */
    public void save(final SysUser sysUser) {
        this.sysUserDao.save(sysUser);
    }

    /**
     * 通过ID查询
     */
    public SysUser findById(final String id) {
        return this.sysUserDao.findById(id).orElse(null);
    }

    /**
     * 通过ID删除
     */
    public void deleteById(String id) {
        this.sysUserDao.deleteById(id);
    }

    /**
     * 通过名称模糊查询
     */
    public List<SysUser> findByName(final String name) {
        return this.sysUserDao.findByUsername(name);
    }

    /**
     * 通过使用注解名称模糊查询
     */
    public List<SysUser> findAllByNameUsingAnnotations(String name) {
        return this.sysUserDao.findAllByUsernameUsingAnnotations(name);
    }

    /**
     * 分页
     *
     * @param size 数量
     */
    public Page<SysUser> findAllByPage(int page, int size) {
        //Sort sort = Sort.by(Sort.Order.desc("create_date"));//排序
        //Pageable pageable =PageRequest.of(Integer.parseInt(page), Integer.parseInt(size), sort);
        Sort sort = Sort.by(Sort.Order.desc("createTime"));//根据
        Pageable pageable = PageRequest.of(page, size, sort);
        return this.sysUserDao.findAll(pageable);
    }

    public Iterable<SysUser> findAll() {
        return this.sysUserDao.findAll();
    }
}
