package com.cjt.pro.logmanager.util;

import android.content.Context;

/**
 * @author 陈君厅
 * @version 1.0
 * @date 2016/11/25
 */
public class Util {

    /**
     * 得到设备的密度
     */
    public static float getScreenDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /**
     * 把密度转换为像素
     */
    public static int dip2px(Context context, float dp) {
        final float scale = getScreenDensity(context);
        return (int) (dp * scale + 0.5);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = getScreenDensity(context);
        return (int) (pxValue / scale + 0.5);
    }

}
