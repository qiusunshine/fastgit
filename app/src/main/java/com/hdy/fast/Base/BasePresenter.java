package com.hdy.fast.Base;

/**
 * 作者：By hdy
 * 日期：On 2017/10/31
 * 时间：At 14:54
 */

public class BasePresenter<V extends BaseView> {

    /**
     * 绑定的view
     */
    private V mvpView;
    /**
     * 绑定view，一般在初始化中调用该方法
     */
    public void attachView(V mvpView) {
        this.mvpView = mvpView;
    }
    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachView() {
        this.mvpView = null;
    }
    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached() {
        return mvpView != null;
    }
    /**
     * 获取连接的view
     */
    public V getView() {
        return mvpView;
    }
}
