package com.mmle.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mmle.dao.IExplorationDao;
import com.mmle.entity.Exploration;
import com.mmle.entity.LawEnforcement;
import com.mmle.serviceImple.IExplorationService;

@Service
public class ExplorationService implements IExplorationService{

	@Resource
	private IExplorationDao explorationDao;


	public boolean add(Exploration exploration) {

		if(explorationDao.insertExploration(exploration)==1)
			return true;
		return false;
	}

	public boolean update(Exploration exploration) {
		if(explorationDao.updateExploration(exploration)==1)
			return true;
		return false;
	}
}
