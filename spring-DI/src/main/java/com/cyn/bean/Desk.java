package com.cyn.bean;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springStudy
 * @Package: com.cyn.bean
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/8/2 14:54
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/8/2 14:54
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Desk {
    private int id;
    private double  price;

    @Override
    public String toString() {
        return "Desk{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
