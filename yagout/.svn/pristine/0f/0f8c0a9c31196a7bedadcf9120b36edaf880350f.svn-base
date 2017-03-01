package com.skeye.yagout.util;

import java.io.Serializable;

public class CommonResult implements Serializable {

    private static final long serialVersionUID = -4934122069527333667L;

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

    private String resultCode;

    private String resultMsg;

    private Boolean isSuccess;

    private Object data;

    private  String  errorException;

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
