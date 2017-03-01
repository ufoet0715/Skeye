package com.skeye.water_fountain.util;

import java.io.Serializable;

public class CommonResult implements Serializable {
private static final long serialVersionUID = 7941149355570542666L;
	
	private String resultCode;
	private String resultMessage;
	private Boolean isSuccess;
	private Object data;
	private String errorException;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrorException() {
		return errorException;
	}

	public void setErrorException(String errorException) {
		this.errorException = errorException;
	}

	public CommonResult() {

	}

	public CommonResult(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public CommonResult(String resultMessage, Boolean isSuccess) {
		this.resultMessage = resultMessage;
		this.isSuccess = isSuccess;
	}

	public void setMessage(String resultMessage, Boolean isSuccess)
	{
		this.isSuccess=isSuccess;
		boolean hasMessage=false;
		if(resultMessage!=null)
		{
			hasMessage=true;
			this.resultMessage=resultMessage;
		}
		if(isSuccess)
		{
			this.resultCode="000";
			if(!hasMessage)
			{
				this.resultMessage = "操作成功";
			}
		}
		else
		{
			this.resultCode="999";
			if(!hasMessage)
			{
				this.resultMessage = "操作失败";
			}
		}
	}
}
