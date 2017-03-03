package com.qf.threecolths.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class AssortInfo {
    private String img;
    private String name;
    private List<AssortOne> asssort;

    public AssortInfo(){

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AssortOne> getAsssort() {
        return asssort;
    }

    public void setAsssort(List<AssortOne> asssort) {
        this.asssort = asssort;
    }

    @Override
    public String toString() {
        return "AssortInfo{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", asssort=" + asssort +
                '}';
    }
}
