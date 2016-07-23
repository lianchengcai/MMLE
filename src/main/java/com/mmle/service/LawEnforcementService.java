package com.mmle.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mmle.dao.ILawEnforcementDao;
import com.mmle.entity.LawEnforcement;
import com.mmle.serviceImple.ILawEnforcementService;

@Service
public class LawEnforcementService implements ILawEnforcementService{

	@Resource
	private ILawEnforcementDao lawEnforcementDao;

	public boolean add(LawEnforcement lawEnforcement) {
		if(lawEnforcementDao.insertLawEnforcement(lawEnforcement)==1)
			return true;
		return false;
	}

	public boolean delete(int id) {
		if(lawEnforcementDao.deleteLawEnforcementById(id)==1)
			return true;
		return false;
	}

	public boolean update(LawEnforcement lawEnforcement) {
		if(lawEnforcementDao.updateLawEnforcement(lawEnforcement)==1)
			return true;
		return false;
	}
	
	
}
