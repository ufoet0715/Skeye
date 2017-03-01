package com.yagout.defense.dal.model;

public class StationAdapter {
	private int setApNum;
	private int setClientNum;
	private int setMacNum;

	public int getSetApNum() {
		return setApNum;
	}

	public void setSetApNum(int setApNum) {
		this.setApNum = setApNum;
	}

	public int getSetClientNum() {
		return setClientNum;
	}

	public void setSetClientNum(int setClientNum) {
		this.setClientNum = setClientNum;
	}

	public int getSetMacNum() {
		return setMacNum;
	}

	public void setSetMacNum(int setMacNum) {
		this.setMacNum = setMacNum;
	}

	public StationAdapter() {
		this.setApNum = 0;
		this.setClientNum = 0;
		this.setMacNum = 0;
	}
	
	public void addApNum(){
		this.setApNum=this.setApNum + 1 ;
	}
	
	public void addClientNum(){
		this.setClientNum=this.setClientNum + 1 ;
	}
	
	public void addMacNum(){
		this.setMacNum=this.setMacNum + 1 ;
	}
}
