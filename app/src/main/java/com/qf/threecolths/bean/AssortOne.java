package com.qf.threecolths.bean;

/**
 * 第一层，最里面的数据
 * Created by Administrator on 2017/3/2 0002.
 */

public class AssortOne {
    private  String one_name;
    private  String one_name_name;
    private  String one_img;

    public AssortOne(){

    }

    public String getOne_name() {
        return one_name;
    }

    public void setOne_name(String one_name) {
        this.one_name = one_name;
    }

    public String getOne_name_name() {
        return one_name_name;
    }

    public void setOne_name_name(String one_name_name) {
        this.one_name_name = one_name_name;
    }

    public String getOne_img() {
        return one_img;
    }

    public void setOne_img(String one_img) {
        this.one_img = one_img;
    }

    @Override
    public String toString() {
        return "AssortOne{" +
                "one_name='" + one_name + '\'' +
                ", one_name_name='" + one_name_name + '\'' +
                ", one_img='" + one_img + '\'' +
                '}';
    }
}
