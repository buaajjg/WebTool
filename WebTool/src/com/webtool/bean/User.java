package com.webtool.bean;

public class User {
	private String name;
	private String password;
	private User() {
				
	}
	public User(String name, String password){
		this.setName(name);
		this.setPassword(password);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
