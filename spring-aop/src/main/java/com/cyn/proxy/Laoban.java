package com.cyn.proxy;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/8/29 23:07
 */
public class Laoban implements Gongneng {
    public String name ;

    public Laoban(String name) {
        this.name = name;
    }

    @Override
    public void kaihui() {
        System.out.println(name+"老板开会！！");
    }
}
