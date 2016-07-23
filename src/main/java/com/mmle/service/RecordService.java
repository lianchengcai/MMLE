package com.mmle.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mmle.dao.IRecordDao;
import com.mmle.serviceImple.IRecordService;

@Service
public class RecordService implements IRecordService{

	@Resource
	private IRecordDao recordDao;
}
