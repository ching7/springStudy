package com.cyn.config;

import com.sun.istack.internal.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * 文件描述
 *
 * @ProjectName: spring-annotation
 * @Package: com.cyn.config
 * @Date 2020/4/17 15:31
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
@Component
@Validated
// ignoreInvalidFields=true
// ignoreUnknownFields = false
@ConfigurationProperties(prefix = "chenyn.annotation")
public class ConfigurationPropertiesDemo {
    private String test1;
    @NotNull
    private Boolean test2 ;
    // private Boolean ex ;
    private List<String> mylist;
    @DurationUnit(ChronoUnit.SECONDS)
    private Duration testtime;

    private Weight testWeight;

    public Duration getTesttime() {
        return testtime;
    }

    public void setTesttime(Duration testtime) {
        this.testtime = testtime;
    }

    public List<String> getMylist() {
        return mylist;
    }

    public void setMylist(List<String> mylist) {
        this.mylist = mylist;
    }

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public Boolean getTest2() {
        return test2;
    }

    public void setTest2(Boolean test2) {
        this.test2 = test2;
    }
}
