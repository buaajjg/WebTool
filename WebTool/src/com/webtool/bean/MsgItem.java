package com.webtool.bean;

import java.sql.Timestamp;

public class MsgItem {
	private String userName;
	private Timestamp time;
	private String message;
	public MsgItem(String userName, Timestamp time, String message){
		this.setUserName(userName);
		this.setTime(time);
		this.setMessage(message);
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString(){
		return userName+ time.toString()+ message;
	}
	

}
