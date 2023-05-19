package com.example.springbootes;

import com.example.springbootes.Service.EsConfigService;
import com.example.springbootes.Service.SysUserService;
import com.example.springbootes.entity.SysUser;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEsApplicationTests {

    @Resource
    SysUserService sysUserService;
    @Resource
    private EsConfigService esConfigService;
    @Test
    public void testInsert() {
        List<String> list = new ArrayList<>();
        list.add("teacher");
        list.add("student");
        list.add("admin");
        list.add("leader");
        for (int i = 0; i < 10; i++) {
            int toIndex = new Random(1).nextInt(4);
            SysUser sysUser = new SysUser();
            sysUser.setPassword("123456");
            sysUser.setUsername("AI码师" + i);
            sysUser.setLevel(i);
            sysUser.setRoles(list.subList(0, toIndex));
            sysUserService.save(sysUser);
        }
        System.out.printf("结束");
    }

    @Test
    public void testFindAll() {
        Iterable<SysUser> all = sysUserService.findAll();
        all.forEach((sysUser) -> {
            System.out.printf(sysUser.getId());
        });
    }

    @Test
    public void testFindAllAndDel() {
        Iterable<SysUser> all = sysUserService.findAll();
        all.forEach((sysUser) -> {
            System.out.printf(sysUser.getId());
            sysUserService.deleteById(sysUser.getId());
        });
    }

    @Test
    public void findByName() {
        List<SysUser> all = sysUserService.findAllByNameUsingAnnotations("8");
        all.forEach(
                System.out::println
        );
    }

    @Test
    public void getCurrentSeqNo() {
        List<SysUser> all = sysUserService.findAllByNameUsingAnnotations("8");
        all.forEach(
                System.out::println
        );
    }

    @Test
    public void updateIndexReplicas() throws IOException {
        AcknowledgedResponse acknowledgedResponse = esConfigService.updateNumberOfReplicas("sys_user", 2);
        boolean acknowledged = acknowledgedResponse.isAcknowledged();
        System.out.println(acknowledged);
    }
    @Test
    public void updateAliases() throws IOException {
        AcknowledgedResponse acknowledgedResponse = esConfigService.updateAliases("sys_user1", "sys_user");
        boolean acknowledged = acknowledgedResponse.isAcknowledged();
        System.out.println(acknowledged);
    }
    @Test
    public void autoFollowSet() throws IOException {
        org.elasticsearch.client.core.AcknowledgedResponse acknowledgedResponse = esConfigService.autoFollowSet("my-auto-follow",
                "es-212",
                "leader-index-pattern-*",
                "index-pattern-*");
        boolean acknowledged = acknowledgedResponse.isAcknowledged();
        System.out.println(acknowledged);
    }
}
