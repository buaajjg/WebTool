package com.webtool.dao;

import com.webtool.bean.User;

public interface UserDao {
	public boolean logIn(User u);
	public boolean signUp(User u);
	
}
