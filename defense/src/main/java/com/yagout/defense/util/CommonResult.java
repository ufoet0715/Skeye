package com.yagout.defense.util;

import java.io.Serializable;

public class CommonResult implements Serializable {

    private static final long serialVersionUID = -4934122069527333667L;
    /**
     *  结果编码
     */
    private String resultCode;
    /**
     *  结果显示内容
     */
    private String resultMsg;
    /**
     *  结果是否成功
     */
    private Boolean isSuccess;

    /**
     *  结果返回数据
     */
    private Object data;

    private  String  errorException;


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public CommonResult() {
        this(false);
    }

    public CommonResult(Boolean isSuccess) {
        this(isSuccess, null);
    }

    public CommonResult(Boolean isSuccess, String msg) {
        setMesg(isSuccess, msg);
    }

    private void setMesg(Boolean isSuccess, String msg) {
        this.isSuccess = isSuccess;
        boolean hasMsg = false;
        if (msg != null) {
            hasMsg = true;
            this.resultMsg = msg;
        }
        if (isSuccess) {
            this.resultCode = "000";
            if (!hasMsg)
                this.resultMsg = "操作成功";
        } else {
            this.resultCode = "999";
            if (!hasMsg)
                this.resultMsg = "操作失败";
        }

    }



    public String getErrorException() {
        return errorException;
    }

    public void setErrorException(String errorException) {
        this.errorException = errorException;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        setMesg(isSuccess, null);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



}
