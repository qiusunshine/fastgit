package com.hdy.fast.Base;

/**
 * 作者：By hdy
 * 日期：On 2017/10/31
 * 时间：At 15:01
 */
public abstract class BaseModel<T>  {
    //数据请求参数
    protected String[] mParams;
    /**
     * 设置数据请求参数
     * @param args 参数数组
     */
    public  BaseModel<T> params(String... args){
        mParams = args;
        return this;
    }
    // 添加Callback并执行数据请求
    // 具体的数据请求由子类实现
    public abstract void execute(Callback<T> callback);
}