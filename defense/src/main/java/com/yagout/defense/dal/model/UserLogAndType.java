package com.yagout.defense.dal.model;

import java.util.Date;

import com.yagout.defense.util.DateFormatter;

public class UserLogAndType {
	private long id;
	private int userId;
	private String userName;
	private int eventType;
	private String typeName;
	private Date eventTime;
	private int eventResult;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getEventType() {
		return eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getEventTime() {
		return DateFormatter.dateFormat(this.eventTime);
	}

	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}

	public int getEventResult() {
		return eventResult;
	}

	public void setEventResult(int eventResult) {
		this.eventResult = eventResult;
	}

	public UserLogAndType() {

	}
}
