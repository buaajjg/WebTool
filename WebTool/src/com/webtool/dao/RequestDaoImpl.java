package com.webtool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.webtool.bean.RequestRecord;

import DBUtil.DBUtil;

public class RequestDaoImpl implements RequestDao {

	@Override
	public boolean writeRequestRecord(RequestRecord record) {
		DBUtil db= new DBUtil();
		Connection conn = db.getConnection();
		String sql="insert into RequestRecordTb (RequestTime, RequestURI) values(? ,? )";
		try {
			
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setTimestamp(1, record.getRequestTime());
			stmt.setString(2, record.getRequestURI());
			
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
	public int getLastMinuteRequest() {

		DBUtil util= new DBUtil();
		Connection conn= util.getConnection();
		String sql= "select count(*) from RequestRecordTb where (TimeStampDiff(MINUTE,RequestTime, now())<=1)";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			int count=0;
			if(rs.next()){
				count=rs.getInt(1);
				
			}
			conn.close();
			return count;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return 0;
		
	}

	@Override
	public int getLastHourRequest() {
		DBUtil util= new DBUtil();
		Connection conn= util.getConnection();
		String sql= "select count(*) from RequestRecordTb where (TimeStampDiff(HOUR,RequestTime, now())<=1)";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			int count=0;
			if(rs.next()){
				count=rs.getInt(1);
				
			}
			conn.close();
			return count;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return 0;
	}

	@Override
	public int getLastDayRequest() {
		DBUtil util= new DBUtil();
		Connection conn= util.getConnection();
		String sql= "select count(*) from RequestRecordTb where (TimeStampDiff(HOUR,RequestTime, now())<=24)";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			int count=0;
			if(rs.next()){
				count=rs.getInt(1);
				
			}
			conn.close();
			return count;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return 0;
	}

	@Override
	public int getLastWeekRequest() {
		DBUtil util= new DBUtil();
		Connection conn= util.getConnection();
		String sql= "select count(*) from RequestRecordTb where (TimeStampDiff(DAY,RequestTime, now())<=7)";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			int count=0;
			if(rs.next()){
				count=rs.getInt(1);
				
			}
			conn.close();
			return count;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return 0;
	}

	@Override
	public int getLastMonthRequest() {
		DBUtil util= new DBUtil();
		Connection conn= util.getConnection();
		String sql= "select count(*) from RequestRecordTb where (TimeStampDiff(DAY,RequestTime, now())<=30)";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			int count=0;
			if(rs.next()){
				count=rs.getInt(1);
				
			}
			conn.close();
			return count;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return 0;
	}

	@Override
	public int getLastYearRequest() {
		DBUtil util= new DBUtil();
		Connection conn= util.getConnection();
		String sql= "select count(*) from RequestRecordTb where (TimeStampDiff(DAY,RequestTime, now())<=365)";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			int count=0;
			if(rs.next()){
				count=rs.getInt(1);
				
			}
			conn.close();
			return count;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return 0;
	}

}
