package com.hdy.fast.Util;

import com.hdy.fast.Base.BaseModel;

/**
 * 作者：By hdy
 * 日期：On 2017/10/31
 * 时间：At 15:09
 */
public class DataModel {

    public static <T> BaseModel<T> request(String token){
        // 声明一个空的BaseModel
        BaseModel<T> model = null;
        try {
            //利用反射机制获得对应Model对象的引用
            model = (BaseModel<T>)Class.forName(token).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return model;
    }
}