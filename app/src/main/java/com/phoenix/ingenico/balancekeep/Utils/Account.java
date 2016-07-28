package com.phoenix.ingenico.balancekeep.Utils;

/**
 * Created by yawang on 07/07/2016.
 */
public class Account {
    private String name;
    private int img;

    public Account(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
