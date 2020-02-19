package com.cyn.bean;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: spring01-runtime
 * @Package: com.cyn.bean
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/7/31 15:05
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/7/31 15:05
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class PeopleFactory {
    public People createPeople(char choose){
        switch (choose){
            case 'A':
                return new Apeople("A",23);
            case 'B':
                return new Bpeople("B",234);
            default:
                return null;
        }
    }
    public People createPeople(){
        return new Apeople("空",23);
    }
}
