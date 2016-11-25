package com.cjt.pro.logmanager.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈君厅
 * @version 1.0
 * @date 2016/11/23
 */
public class LogItem {

    /**
     * 日志时间精确到毫秒
     */
    private Date date;

    /**
     * 日志产生的包名
     */
    private String pkg;

    /**
     * 日志的等级
     */
    private String level;

    /**
     * 日志的标签
     */
    private String tag;

    /**
     * 日志的内容
     */
    private String msg;

    public LogItem() {
    }

    public LogItem(Date date, String level, String tag, String msg) {
        this.date = date;
        this.level = level;
        this.tag = tag;
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPkg() {
        return pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss:SSS");
        StringBuffer sb = new StringBuffer();
        sb.append(sdf.format(date));
        sb.append("\t");
        sb.append(level.toUpperCase().charAt(0));
        sb.append("\t");
        sb.append(tag);
        sb.append(":");
        sb.append(msg);
        sb.append("\n");
        return sb.toString();
    }
}
