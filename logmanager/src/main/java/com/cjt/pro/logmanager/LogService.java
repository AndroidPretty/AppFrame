package com.cjt.pro.logmanager;

import android.util.Log;

import com.cjt.pro.logmanager.entity.LogItem;
import com.cjt.pro.logmanager.util.FileUtil;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author 陈君厅
 * @version 1.0
 * @date 2016/11/23
 */
public class LogService {

    private static final String TAG = "LogService";

    private static final int MAX_SIZE = 1000;

    private static String path;

    private static String filename;

    private static FileWriter fw;

    private static BlockingDeque<LogItem> queue = null;

    private static Thread thread;

    static Runnable write = new Runnable() {
        @Override
        public void run() {
            boolean loop = true;
            while (loop) {
                LogItem log = getLog();
                if (fw != null) {
                    try {
                        fw.write(log.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                        FileUtil.closeFw(fw);
                        fw = null;
                    } finally {
                        if (fw != null) {
                            try {
                                fw.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    Log.d(TAG, "FileWriter为空，停止日志记录服务");
                    loop = false;
                }
            }
        }
    };

    static {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取sd卡根路径，创建filewriter
        path = FileUtil.getBasePath();
        if (path != null) {
            path = path + "/CJT/log/store";
            filename = sdf.format(new Date()) + "_log.clog";
            try {
                fw = FileUtil.getFileWriter(path, filename);
            } catch (IOException e) {
                Log.d(TAG, "创建FileWriter发生异常！");
                fw = null;
                e.printStackTrace();
            }
        } else {
            Log.e("LogManager", "日志记录服务获取FileWriter失败，由于sd路径获取失败！");
        }

        queue = new LinkedBlockingDeque<>(MAX_SIZE);
        //启动线程读取队列里面的信息写入文件
        thread = new Thread(write);
        thread.start();
    }

    public static void addLog(LogItem log) {
        try {
            queue.put(log);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static LogItem getLog() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
