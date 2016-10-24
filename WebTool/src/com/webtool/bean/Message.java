package com.webtool.bean;


public class Message {
	
	private String msg;
	private int userId;
	public Message(){
		
		setMsg("");
		setUserId(-1);
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
