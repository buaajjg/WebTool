package com.webtool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.webtool.bean.Message;
import com.webtool.bean.MsgItem;

import DBUtil.DBUtil;

public class MsgDaoImpl implements MsgDao {

	@Override
	public boolean post(Message msg) {
		DBUtil db= new DBUtil();
		Connection conn= db.getConnection();
		String message= msg.getMsg();
		int userId=msg.getUserId();
		String sql="insert into MsgTb (Time, Message, UserId) values(now(), ?, ? )";
		
		
		try {
			
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, message);
			stmt.setInt(2, userId);
			stmt.executeUpdate();
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<MsgItem> getRecord() {
		
		List<MsgItem> list =new ArrayList<>();
		
		DBUtil util= new DBUtil();
		Connection conn= util.getConnection();
		String sql= "select UserName, Time, Message from UserTb join MsgTb on UserTb.UserId=MsgTb.UserId order by Time";
		
		try {
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				String userName=rs.getString(1);
				Timestamp time= rs.getTimestamp(2);
				String message=rs.getString(3);
				MsgItem item= new MsgItem(userName, time, message);
				
				list.add(item);
				
			}
			conn.close();
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return null;
	}

}
