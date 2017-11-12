package com.hdy.fast.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.KeyEvent;
import android.view.View;
import com.hdy.fast.Base.BaseActivity;
import com.hdy.fast.R;

public class MainActivity extends BaseActivity implements MainView {

   private UserPresenter userPresenter;
    @Override
    protected void initLayout(Bundle savedInstanceState) {
    setTheme(R.style.AppTheme);//因为设置了启动页windowbackground
    setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        userPresenter=new UserPresenter();
        userPresenter.attachView(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        if(userPresenter.isViewAttached()){
            userPresenter.getData();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showErr(String msg) {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showData(String data) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userPresenter.detachView();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK) { //按下的如果是BACK，同时没有重复
            /**
            Snackbar.make(,"确定退出本软件？",Snackbar.LENGTH_SHORT).setAction("退出", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.exit(0);
                }
            }).show();
             return true;
             *
             */
            // TODO: 2017/11/12 退出处理，找到view
        }
        return super.onKeyDown(keyCode, event);
    }
}
