package com.webtool.bean;

import java.sql.Timestamp;

public class RequestRecord {
	private Timestamp requestTime;
	private String requestURI;
	
	public RequestRecord(Timestamp requestTime, String requestURI){
		this.requestTime=requestTime;
		this.requestURI=requestURI;
	}
	public Timestamp getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Timestamp requestTime) {
		this.requestTime = requestTime;
	}
	public String getRequestURI() {
		return requestURI;
	}
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

}
