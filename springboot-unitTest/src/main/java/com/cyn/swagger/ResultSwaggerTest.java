package com.cyn.swagger;

import com.cyn.bean.UserBean;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: testSwaager
 * @Author: ynchen9
 * @CreateTime: 2021-11-30
 */
@Api(value = "ResultSwaggerTest", tags = {"ResultSwaggerTest"})
@RestController
public class ResultSwaggerTest {

    /**
     * test get
     *
     * @return
     */
    @ApiOperation(value = "test get", notes = "", httpMethod = "GET")
    @GetMapping("/swagger/test/get")
    public ResultDataBase<UserBean> getUser() {
        UserBean userBean = new UserBean("wanger", "123");
        ResultDataBase<UserBean> result = new ResultDataBase<>();
        result.setSuccess(true);
        result.setCode("200");
        result.setData(userBean);
        result.setMessage("success user");
        return result;
    }
}
