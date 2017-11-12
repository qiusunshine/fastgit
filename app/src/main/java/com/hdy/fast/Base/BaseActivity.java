package com.hdy.fast.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

 public abstract class BaseActivity extends AppCompatActivity {
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            initLayout(savedInstanceState);
            initView();
            processLogic(savedInstanceState);
        }
         public void onResume() {
        super.onResume();
    }
         public void onPause() {
        super.onPause();
    }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            return item.getItemId() == android.R.id.home || super.onOptionsItemSelected(item);
        }
        /**
         * 初始化布局
        */
        protected abstract void initLayout(Bundle savedInstanceState);
        /**
         * 初始化布局以及View控件
         */
        protected abstract void initView();

        /**
         * 处理业务逻辑，状态恢复等操作
         *
         * @param savedInstanceState 鬼知道
         */
        protected abstract void processLogic(Bundle savedInstanceState);
        /**
         * 查找View
         *
         * @param id   控件的id
         * @param <VT> View类型
         * @return 鬼知道
         */
        protected <VT extends View> VT findView(@IdRes int id) {
            return (VT) findViewById(id);
        }

        @Override
        protected void onStop() {
            super.onStop();
        }
        protected Context getContext(){
            return this;
        }
}
