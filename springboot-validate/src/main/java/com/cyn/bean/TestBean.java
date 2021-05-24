package com.cyn.bean;

import com.cyn.validated.FlagValidator;
import com.cyn.validated.IsLeek;
import com.cyn.validated.ValidNum100;
import org.springframework.context.annotation.Bean;

/**
 * @Description:
 * @Author: ynchen9
 * @CreateTime: 2021-05-24
 */
public class TestBean {
    @ValidNum100(value = "25")
    @IsLeek
    private String testS;

    @FlagValidator(value = {0, 1}, message = "预约状态参数错误")
    private Integer testI;

    public String getTestS() {
        return testS;
    }

    public void setTestS(String testS) {
        this.testS = testS;
    }

    public Integer getTestI() {
        return testI;
    }

    public void setTestI(Integer testI) {
        this.testI = testI;
    }
}
