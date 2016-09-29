package com.webtool.dao;

import java.sql.*;

import com.webtool.bean.User;

import DBUtil.DBUtil;


public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean logIn(User u) {
		// TODO Auto-generated method stub
		DBUtil util= new DBUtil();
		Connection conn= util.getConnection();
		System.out.println("conn"+conn);
		String sql= "select password from UserTb where Username='";
		String name=u.getName();
		String password=u.getPassword();
		try {
			Statement stmt=conn.createStatement();
			System.out.println(sql+name+"'");
			ResultSet rs=stmt.executeQuery(sql+name+"'");
			while(rs.next()){
				
				System.out.println("1--"+rs.getString(1));
				if(rs.getString(1).equals(password)){
					return true;
				}
			}
			conn.close();
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean signUp(User u) {
		// TODO Auto-generated method stub
		DBUtil util=new DBUtil();
		Connection conn= util.getConnection();
		String sql="insert into UserTb(Username, password) values(?,?)";
		String name=u.getName();
		String password=u.getPassword();
		try {
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from UserTb where Username='"+name+"'");
			
			if(rs.next()){
				return false;
			}
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.executeUpdate();
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
