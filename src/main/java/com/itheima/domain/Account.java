package com.itheima.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = -5603642298244790624L;

    private Integer id;
    private Integer uid;
    private Double money;
 /*   private User user;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }


    public Account(){}

    public Account(Integer id, Integer uid, Double money) {
        this.id = id;
        this.uid = uid;
        this.money = money;

    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
