package com.example.springbootes;

import com.example.springbootes.Dao.SysUserDao;
import com.example.springbootes.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEsApplicationTests {

    @Resource
    SysUserDao sysUserDao;

    @Test
    public void testInsert() {
        List<String> list = new ArrayList<>();
        list.add("teacher");
        list.add("student");
        list.add("admin");
        list.add("leader");
        for (int i = 0; i < 10; i++) {
            int toIndex = new Random(1).nextInt(4);
            SysUser build = SysUser.builder()
                    .password("123456")
                    .username("AI码师")
                    .level(i)
                    .roles(list.subList(0, toIndex))
                    .build();
            sysUserDao.save(build);
        }
        System.out.printf("结束");
    }

    @Test
    public void testFindAll() {
        Iterable<SysUser> all = sysUserDao.findAll();
        all.forEach((sysUser) -> {
            System.out.printf(sysUser.getId());
        });
    }
}
