package com.hdy.fast.Home;

import android.os.Handler;
import com.hdy.fast.Base.BaseModel;
import com.hdy.fast.Base.Callback;

/**
 * 作者：By hdy
 * 日期：On 2017/10/31
 * 时间：At 15:05
 */
public class UserDataModel extends BaseModel<String> {
    @Override
    public void execute(final Callback<String> callback) {
        // TODO: 2017/10/31 根据需要改写请求
        // 模拟网络请求耗时操作
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // mParams 是从父类得到的请求参数
                switch (mParams[0]){
                    case "normal":
                        callback.onSuccess("根据参数"+mParams[0]+"的请求网络数据成功");
                        break;
                    case "failure":
                        callback.onFailure("请求失败：参数有误");
                        break;
                    case "error":
                        callback.onError("error");
                        break;
                }
                callback.onComplete();
            }
        },2000);
    }
}