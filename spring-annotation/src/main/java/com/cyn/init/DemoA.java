package com.cyn.init;

/**
 * 文件描述
 *
 * @ProjectName: spring-annotation
 * @Package: com.cyn.init
 * @Date 2020/5/6 19:46
 * @Author: chenyn22577
 * @Version: 1.0
 * @Description: note
 **/
public class DemoA {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DemoA{" +
                "name='" + name + '\'' +
                '}';
    }

    public DemoA(String name) {
        this.name = name;
    }
}
