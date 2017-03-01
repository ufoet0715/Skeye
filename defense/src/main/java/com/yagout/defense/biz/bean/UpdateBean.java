package com.yagout.defense.biz.bean;

import java.io.Serializable;

/**
 * Created by Skeyedu on 2017/2/13.
 */
public class UpdateBean implements Serializable {

    private  String fileName;//文件名称

    private String  iniText;//ini文件内容


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getIniText() {
        return iniText;
    }

    public void setIniText(String iniText) {
        this.iniText = iniText;
    }
}
