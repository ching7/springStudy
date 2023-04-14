package org.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.iflytek.sec.uap.client.rest.context.UapServiceContext;
import com.iflytek.sec.uap.client.rest.service.TicketService;
import com.iflytek.sec.uap.client.rest.service.ValidateService;
import com.iflytek.sec.uap.model.UapUser;
import com.iflytek.sec.uap.util.Constant;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * @ClassName LoginController
 * @Description
 * @Author ynchen
 * @Date 2023/4/13 15:26
 * @Version V1.0.0
 */
@RestController
@RequestMapping
public class LoginController {
    String homePage = "http://localhost:8190/login/";

    @GetMapping("/login/")
    public String login(HttpServletRequest request) {
        UapUser user = null;
        return "login";
    }

    @GetMapping("/test/get")
    public String get(HttpServletRequest request) {
        UapUser user1 = UapServiceContext.getUserService().getCurrentLoginUser(request.getSession());
        System.out.println(user1);
        return UUID.randomUUID().toString();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(Constant.SESSION_USER);
        request.getSession().invalidate();
        return "redirect:" + Constant.getCasLogoutUrl(request.getContextPath());
    }
}
