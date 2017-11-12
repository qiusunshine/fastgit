package com.hdy.fast.Util;

/**
 * 作者：By hdy
 * 日期：On 2017/11/6
 * 时间：At 16:51
 */
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastMgr {

    /**
     * 屏幕底部中间位置显示短时间Toast
     *
     * @param context
     * @param message
     */
    public static void ToastShortBottomCenter(Context context, String message) {
        if (context != null) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 屏幕中心位置短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void ToastShortCenter(Context context, String message) {
        if (context != null) {

            Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }

}
