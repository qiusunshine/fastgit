package com.hdy.fast.FastCopy;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import com.hdy.fast.Base.BaseActivity;
import com.hdy.fast.R;

public class activity_recyclerview extends BaseActivity {
    private adapter_recyclerview adapter_test1_1;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recyclerview, menu);//加载menu文件到布局
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()) //得到被点击的item的itemId
        {
            case  R.id.birth_pic :  //对应的ID就是在add方法中所设定的Id
                break;

        }
        return true;
    }

    @Override
    protected void initLayout(Bundle savedInstanceState) {
        setContentView(R.layout.activity_recyclerview);
    }

    @Override
    protected void initView() {
        RecyclerView idRecycleview = findView(R.id.id_recycleview);
        swipeRefreshLayout=findView(R.id.test1_1_swipeRefreshLayout);
        swipeRefreshLayout.setRefreshing(true);
        idRecycleview.setLayoutManager(new LinearLayoutManager(this));
        idRecycleview.setItemAnimator(new DefaultItemAnimator());
        idRecycleview.setAdapter(adapter_test1_1);
        load();
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                load();
            }
        });
    }
    public void load() {
    }
}
