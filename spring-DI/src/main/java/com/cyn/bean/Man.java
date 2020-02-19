package com.cyn.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: springStudy
 * @Package: com.cyn.bean
 * @Description: note
 * @Author: hspcadmin
 * @CreateDate: 2019/8/2 11:14
 * @UpdateUser: hspcadmin
 * @UpdateDate: 2019/8/2 11:14
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * <p>
 * Copyright © 2019 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Man {
    private String name;
    private String id ;
    private List<String> listMan;
    private String[] strs;
    private Map<String,String> map;
    private Desk desk;

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", listMan=" + listMan +
                ", strs=" + Arrays.toString(strs) +
                ", map=" + map +
                ", desk=" + desk +
                '}';
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public List<String> getListMan() {
        return listMan;
    }

    public void setListMan(List<String> listMan) {
        this.listMan = listMan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println(" use setName ");
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        System.out.println(" use setId ");

        this.id = id;
    }

}
