package com.qf.threecolths.application;

import android.app.Application;

import org.xutils.x;


/**
 * Created by Administrator on 2017/3/3 0003.
 */

public class ThreeColthsApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
