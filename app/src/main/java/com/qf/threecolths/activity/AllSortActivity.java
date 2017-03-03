package com.qf.threecolths.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.qf.threecolths.R;
import com.qf.threecolths.fragments.AssortFragment;
import com.qf.threecolths.fragments.FindFragment;
import com.qf.threecolths.fragments.IndexFragment;
import com.qf.threecolths.fragments.MeFragment;
import com.qf.threecolths.fragments.ShopcarFragment;

public class AllSortActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup rg;
    private RadioButton index;
    private IndexFragment indexFragment;
    private AssortFragment assortFragment;
    private FindFragment findFragment;
    private ShopcarFragment shopcarFragment;
    private MeFragment meFragment;
    private Fragment fragment;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    /**
     * 初始化
     */
    private void init() {
        findView();
        setClickListener();

        index.setChecked(true);//设置第一个碎片被选中
        //创建碎片对象
        indexFragment = new IndexFragment();
        assortFragment = new AssortFragment();
        findFragment = new FindFragment();
        shopcarFragment = new ShopcarFragment();
        meFragment = new MeFragment();

        //默认加载第一个碎片
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.recplaceId, indexFragment);
        transaction.commit();
        fragment = indexFragment;
    }

    /**
     * 设置监听
     */
    private void setClickListener() {
        rg.setOnCheckedChangeListener(this);
    }

    /**
     * 找控件id
     */
    private void findView() {
        rg = (RadioGroup) findViewById(R.id.rg);
        index = (RadioButton) findViewById(R.id.index);
    }

    /**
     * 碎片被改变，不会重新加载
     */
    private void fragmentRecycle(Fragment NextFragment){
        if(fragment != NextFragment){
            transaction = manager.beginTransaction();
            if(!NextFragment.isAdded()){//判断点击的碎片是否被添加
                //隐藏当前页面，下一个添加进去
                transaction.hide(fragment)
                        .add(NextFragment,null)
                        .commit();
            }
            else {
                transaction.hide(fragment).show(NextFragment);
            }
        }
        fragment = NextFragment;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.index:
                fragmentRecycle(indexFragment);
                break;
            case R.id.assort:
                fragmentRecycle(assortFragment);
                break;
            case R.id.find:
                fragmentRecycle(findFragment);
                break;
            case R.id.shopcar:
                fragmentRecycle(shopcarFragment);
                break;
            case R.id.me:
                fragmentRecycle(meFragment);
                break;
        }
    }
}
