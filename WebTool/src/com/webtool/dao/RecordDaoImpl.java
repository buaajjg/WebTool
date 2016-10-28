package com.webtool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.webtool.bean.RecordItem;
import com.webtool.bean.VisitRecord;

import DBUtil.DBUtil;

public class RecordDaoImpl implements RecordDao {

	@Override
	public boolean writeRecord(VisitRecord record) {
		// TODO Auto-generated method stub
		DBUtil db= new DBUtil();
		Connection conn = db.getConnection();
		String sql="insert into VisitRecordTb (SessionId, StartTime, EndTime, UserId) values(?, ?, ?,? )";
		try {
			
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, record.getSessionId());
			stmt.setTimestamp(2, record.getStartTime());
			stmt.setTimestamp(3, record.getEndTime());
			stmt.setInt(4, record.getUserId());
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
	public List<RecordItem> getRecord() {
		// TODO Auto-generated method stub
		List<RecordItem> list =new ArrayList<>();
		
		DBUtil util= new DBUtil();
		Connection conn= util.getConnection();
		String sql= "select SessionId, StartTime,EndTime, UserName from UserTb join VisitRecordTb on UserTb.UserId=VisitRecordTb.UserId order by StartTime";
		
		try {
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				String sessionId=rs.getString(1);
				Timestamp startTime= rs.getTimestamp(2);
				Timestamp endTime= rs.getTimestamp(3);
				String userName=rs.getString(4);
				RecordItem item= new RecordItem();
				item.setSessionId(sessionId);
				item.setStartTime(startTime);
				item.setEndTime(endTime);
				item.setUserName(userName);
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

	@Override
	public int lastOneHourVisit() {
		// TODO Auto-generated method stub
		DBUtil util= new DBUtil();
		Connection conn= util.getConnection();
		String sql= "select count(*) from VisitRecordTb where (TimeStampDiff(HOUR,EndTime, now())<=1)";
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
	public int lastOneDayVisit() {
		// TODO Auto-generated method stub
		DBUtil util= new DBUtil();
		Connection conn= util.getConnection();
		String sql= "select count(*) from VisitRecordTb where (TimeStampDiff(HOUR, EndTime, now())<=24)";
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
	public int lastOneWeekVisit() {
		// TODO Auto-generated method stub
		DBUtil util= new DBUtil();
		Connection conn= util.getConnection();
		String sql= "select count(*) from VisitRecordTb where (TimeStampDiff(DAY,EndTime, now())<=7)";
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
	public int lastOneMonthVisit() {
		// TODO Auto-generated method stub
		DBUtil util= new DBUtil();
		Connection conn= util.getConnection();
		String sql= "select count(*) from VisitRecordTb where (TimeStampDiff(DAY, EndTime, now())<=30)";
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
