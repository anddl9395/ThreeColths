package com.qf.threecolths.perenster.impl;


import com.qf.threecolths.bean.AssortInfo;
import com.qf.threecolths.bean.AssortOne;
import com.qf.threecolths.callback.CallBack;
import com.qf.threecolths.dao.IThreeColths;
import com.qf.threecolths.dao.impl.ThreeColths;
import com.qf.threecolths.fragments.interfaces.IAssortFragment;
import com.qf.threecolths.perenster.IAssort;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class Assort implements IAssort {
    IThreeColths threeColths = new ThreeColths();
    IAssortFragment iAssortFragment;
    public Assort(IAssortFragment iAssortFragment){
        this.iAssortFragment = iAssortFragment;
    }

    CallBack callBack = new CallBack() {
        @Override
        public void getResult(String result) {
            try {
                JSONObject jsonObject = new JSONObject(result);
                String str = jsonObject.getString("success");
                if("true".equals(str)){
                    JSONObject msg = new JSONObject(result);
                    JSONArray category = msg.getJSONArray("category");
                    List<AssortInfo> list = new ArrayList<>();
                    AssortInfo assortInfo = null;
                    for (int i = 0; i < category.length(); i++) {
                        JSONObject mes = category.getJSONObject(i);
                        assortInfo = new AssortInfo();
                        assortInfo.setImg(mes.getString("img"));
                        assortInfo.setName(mes.getString("name"));

                        JSONArray list2 = mes.getJSONArray("list2");
                        List<AssortOne> list1 = new ArrayList<>();
                        for (int j = 0; j < list2.length(); j++) {
                            JSONObject data = list2.getJSONObject(j);
                            JSONArray data1 = data.getJSONArray("list2");
                            AssortOne assortOne = null;
                            for (int k = 0; k < data1.length(); k++) {
                                JSONObject data2 = data1.getJSONObject(k);
                                assortOne = new AssortOne();
                                assortOne.setOne_name(data.getString("name"));
                                assortOne.setOne_name_name(data2.getString("name"));
                                assortOne.setOne_img(data2.getString("img"));
                            }
                            list1.add(assortOne);
                        }
                        assortInfo.setAsssort(list1);
                    }
                    list.add(assortInfo);

                    iAssortFragment.successInfo(list);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    public void assort(String url) {
        threeColths.assort(url,callBack);
    }
}
