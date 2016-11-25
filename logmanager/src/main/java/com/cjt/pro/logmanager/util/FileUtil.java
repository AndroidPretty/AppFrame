package com.cjt.pro.logmanager.util;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件常用工具类
 *
 * @author 陈君厅
 * @version 1.0
 * @date 2016/11/25
 */
public class FileUtil {

    public static boolean createDir(String path){
        File file = new File(path);
        if(!file.exists()){
            return file.mkdirs();
        }
        return true;
    }

    public static String getBasePath(){
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return Environment.getExternalStorageDirectory().toString();
        }else{
            Log.e("LogManager", "日志记录服务获取sd路径失败！");
            return null;
        }
    }

    public static FileWriter getFileWriter(String path, String filename) throws IOException {
        boolean b = createDir(path);
        if(b){
            File file = new File(path, filename);
            return new FileWriter(file, true);
        }else{
            Log.e("LogManager", "日志记录服务创建文件夹失败！");
            return null;
        }
    }

    public static void closeFw(FileWriter fw){
        if(fw != null){
            try {
                fw.flush();
            } catch (IOException e) {
                Log.e("LogManager", "日志记录服务FileWriter关闭失败！");
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                Log.e("LogManager", "日志记录服务FileWriter关闭失败！");
                e.printStackTrace();
            }
        }
    }

}
