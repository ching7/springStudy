package com.cyn.controller;

import com.cyn.bean.RoleNum;
import com.cyn.bean.TestBean;
import com.cyn.bean.Users;
import com.cyn.validated.FlagValidator;
import com.cyn.validated.ValidNum100;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/10/10 22:11
 */
@RestController
public class UserController {

    @ValidNum100(value = "10")
    public static String name = "test";

    /**
     * valid功能验证
     *
     * @param value
     * @return
     */
    @RequestMapping("/testValid")
    @ValidNum100(value = "10")
    public String testValid(TestBean value) {
        TestBean testBean = new TestBean();
        testBean.setTestS("20S");
        testBean.setTestI(20);
        System.out.println("value");
        String returnName = name;
        return returnName;
    }

    /**
     * 视图跳转
     * 解决异常的方法：
     * 由于springmvc会将该对象放入到modelAndView中传递,以类名的驼峰命名作为key
     * 参数名称必须与对象名称相同，类名首字母小写
     * <p>
     * 或者用@ModelAttribute
     *
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page, @ModelAttribute("userA") Users users) {
        System.out.println("helloaaqwe");
        return page;
    }

    /**
     * 用户添加
     *
     * @param users
     * @return
     * @Valid 开启对Users的对象数据校验
     * @BindingResult 封装了校验的结果
     */
    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("userA") @Valid Users users, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        System.out.println(users);
        return "ok";
    }

}
