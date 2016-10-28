package com.webtool.dao;

import java.util.List;

import com.webtool.bean.RecordItem;
import com.webtool.bean.VisitRecord;

public interface RecordDao {
	public boolean writeRecord(VisitRecord record);
	public List<RecordItem> getRecord();
	public int lastOneHourVisit();
	public int lastOneDayVisit();
	public int lastOneWeekVisit();
	public int lastOneMonthVisit();
}
