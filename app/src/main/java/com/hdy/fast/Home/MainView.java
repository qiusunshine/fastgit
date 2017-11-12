package com.hdy.fast.Home;

import com.hdy.fast.Base.BaseView;

/**
 * 作者：By hdy
 * 日期：On 2017/10/31
 * 时间：At 14:57
 */

public interface MainView extends BaseView {
    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(String data);
}
