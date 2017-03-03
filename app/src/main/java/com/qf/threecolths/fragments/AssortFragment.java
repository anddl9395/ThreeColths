package com.qf.threecolths.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qf.threecolths.R;
import com.qf.threecolths.bean.AssortInfo;
import com.qf.threecolths.fragments.interfaces.IAssortFragment;
import com.qf.threecolths.perenster.IAssort;
import com.qf.threecolths.perenster.impl.Assort;
import com.qf.threecolths.utils.Util;

import java.util.List;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class AssortFragment extends Fragment implements IAssortFragment {
    private IAssort iAssort;
    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.assort,null);
        init(view);
        load();
        return view;
    }
    /**
     * 初始化
     * @param view
     */
    private void init(View view) {
        iAssort = new Assort(this);
    }
    /**
     * 加载数据
     */
    private void load() {
        iAssort.assort(Util.assortUrl);
    }

    @Override
    public void successInfo(List<AssortInfo> list) {
        Log.i("------结果----",list.toString());
    }
}
