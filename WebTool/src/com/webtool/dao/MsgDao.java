package com.webtool.dao;

import java.util.List;

import com.webtool.bean.Message;
import com.webtool.bean.MsgItem;

public interface MsgDao {
	public boolean post(Message msg);
	public List<MsgItem> getRecord();

}
