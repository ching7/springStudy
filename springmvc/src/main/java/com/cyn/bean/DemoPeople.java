package com.cyn.bean;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springmvc
 * @Package: com.cyn.bean
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/9/27 9:59
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/9/27 9:59
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class DemoPeople {
    private People people;

    @Override
    public String toString() {
        return "DemoPeople{" +
                "people=" + people +
                '}';
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
