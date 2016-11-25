package com.cjt.pro.logmanager;

import android.util.Log;

import com.cjt.pro.logmanager.entity.LogItem;

import java.util.Date;

/**
 * @author 陈君厅
 * @version 1.0
 * @date 2016/11/23
 */
public class CLog {

    public static void v(String tag, String msg){
        Log.v(tag, msg);
        LogService.addLog(new LogItem(new Date(), "Verbose", tag, msg));
    }

    public static void d(String tag, String msg){
        Log.d(tag, msg);
        LogService.addLog(new LogItem(new Date(), "Debug", tag, msg));
    }

    public static void i(String tag, String msg){
        Log.i(tag, msg);
        LogService.addLog(new LogItem(new Date(), "Info", tag, msg));
    }

    public static void w(String tag, String msg){
        Log.w(tag, msg);
        LogService.addLog(new LogItem(new Date(), "Warn", tag, msg));
    }

    public static void e(String tag, String msg){
        Log.e(tag, msg);
        LogService.addLog(new LogItem(new Date(), "Error", tag, msg));
    }

}
