package com.cyn.proxy;

/**
 * @author chenyn
 * @version 1.0
 * @date 2019/8/29 23:07
 */
public class Mishu implements Gongneng {
    private Laoban laoban = new Laoban("马云");
    @Override
    public void kaihui() {
        System.out.println("今天12点开会");
        laoban.kaihui();
        System.out.println("晚上吃饭！！");
    }
}
