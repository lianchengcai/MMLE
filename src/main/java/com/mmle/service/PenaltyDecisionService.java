package com.mmle.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mmle.dao.IPenaltyDecisionDao;
import com.mmle.entity.PenaltyDecision;
import com.mmle.serviceImple.IPenaltyDecisionService;

@Service
public class PenaltyDecisionService implements IPenaltyDecisionService{

	@Resource
	private IPenaltyDecisionDao penaltyDecisionDao;

	public boolean add(PenaltyDecision penaltyDecision) {
		if(penaltyDecisionDao.insertPenaltyDecision(penaltyDecision)==1)
			return true;
		return false;
	}
	
	public boolean update(PenaltyDecision penaltyDecision) {
		if(penaltyDecisionDao.updatePenaltyDecision(penaltyDecision)==1)
			return true;
		return false;
	}
}
