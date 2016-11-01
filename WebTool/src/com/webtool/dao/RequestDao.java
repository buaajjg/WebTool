package com.webtool.dao;

import com.webtool.bean.RequestRecord;

public interface RequestDao {
	public boolean writeRequestRecord(RequestRecord record);
	public int getLastMinuteRequest();
	public int getLastHourRequest();
	public int getLastDayRequest();
	public int getLastWeekRequest();
	public int getLastMonthRequest();
	public int getLastYearRequest();

}
