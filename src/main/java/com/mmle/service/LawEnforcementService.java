package com.mmle.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mmle.dao.ILawEnforcementDao;
import com.mmle.serviceImple.ILawEnforcementService;

@Service
public class LawEnforcementService implements ILawEnforcementService{

	@Resource
	private ILawEnforcementDao lawEnforcementDao;
}
