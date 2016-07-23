package com.mmle.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mmle.dao.IRecordDao;
import com.mmle.entity.LawEnforcement;
import com.mmle.entity.Record;
import com.mmle.serviceImple.IRecordService;

@Service
public class RecordService implements IRecordService{

	@Resource
	private IRecordDao recordDao;

	public boolean add(Record record) {
		if(recordDao.insertRecord(record)==1)
			return true;
		return false;
	}

	public boolean update(Record record) {
		if(recordDao.updateRecord(record)==1)
			return true;
		return false;
	}
}
