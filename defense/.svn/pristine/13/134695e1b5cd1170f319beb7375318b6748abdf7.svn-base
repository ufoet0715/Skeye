package com.yagout.defense.biz.bean;

import java.io.Serializable;
import java.util.Date;

import com.yagout.defense.util.SoketEnum;

/**
 * Created by Skeyedu on 2017/2/9.
 */
public class SoketBean implements Serializable {

    /**
     * 接口类型
     */
    private SoketEnum soketEnum;
    /**
     * 流水号 一次请求就 一个流水号,防止重复操作
     *
     */
    private String no;

    /**
     * 传递数据
     */
    private Object  data;

    /**
     * 时间
     */
    private Date  time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public SoketEnum getSoketEnum() {
        return soketEnum;
    }

    public void setSoketEnum(SoketEnum soketEnum) {
        this.soketEnum = soketEnum;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
