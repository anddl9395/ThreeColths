package com.qf.threecolths.dao.impl;

import com.qf.threecolths.callback.CallBack;
import com.qf.threecolths.dao.IThreeColths;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2017/3/3 0003.
 */

public class ThreeColths implements IThreeColths{
    /**
     * 分类页面
     * @param url
     */
    @Override
    public void assort(String url, final CallBack callBack) {
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callBack.getResult(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
