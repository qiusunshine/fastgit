package com.hdy.fast.Home;

import com.hdy.fast.Base.BaseModel;
import com.hdy.fast.Base.BasePresenter;
import com.hdy.fast.Base.Callback;
import com.hdy.fast.Util.DataModel;
import com.hdy.fast.Util.Token;

/**
 * 作者：By hdy
 * 日期：On 2017/10/31
 * 时间：At 15:12
 */

public class UserPresenter extends BasePresenter<MainView> {
    public void getData(){
        BaseModel<String> baseModel= DataModel.request(Token.API_USER_DATA);// 设置请求标识token
        baseModel.params("normal") // 添加请求参数，没有则不添加
            .execute(new Callback<String>() {

                        @Override
                        public void onSuccess(String data) {
                            //调用view接口显示数据
                            getView().showData(data);
                        }

                        @Override
                        public void onFailure(String msg) {
                            //调用view接口提示失败信息
                            getView().showErr(msg);
                        }

                        @Override
                        public void onError(String msg) {
                            //调用view接口提示失败信息
                            getView().showErr(msg);
                        }

                        @Override
                        public void onComplete() {
                            // 隐藏正在加载进度条
                            getView().hideLoading();
                        }
                    });
    }
}
