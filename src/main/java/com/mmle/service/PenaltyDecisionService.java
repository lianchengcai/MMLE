package com.mmle.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mmle.dao.ILawEnforcementDao;
import com.mmle.dao.IPenaltyDecisionDao;
import com.mmle.entity.LawEnforcement;
import com.mmle.entity.PenaltyDecision;
import com.mmle.serviceImple.ILawEnforcementService;
import com.mmle.serviceImple.IPenaltyDecisionService;

@Service
public class PenaltyDecisionService implements IPenaltyDecisionService{

	@Resource
	private IPenaltyDecisionDao penaltyDecisionDao;
	@Resource
	private ILawEnforcementDao lawEnforcementDao;

	public boolean add(PenaltyDecision penaltyDecision) {
		if(penaltyDecisionDao.selectPenaltyDecisionByLawEnforcementId(
				penaltyDecision.getLawEnforcementId())!=null){
			return false;
		}
		if(penaltyDecisionDao.insertPenaltyDecision(penaltyDecision)==1)
		{
			LawEnforcement lawEnforcement = new LawEnforcement();
			lawEnforcement.setId(penaltyDecision.getLawEnforcementId());
			lawEnforcement.setState(1);
			if(lawEnforcementDao.updateLawEnforcement(lawEnforcement)==1){
				return true;
			}
		}
		return false;
	}
	
	public boolean update(PenaltyDecision penaltyDecision) {
		if(penaltyDecisionDao.updatePenaltyDecision(penaltyDecision)==1)
			return true;
		return false;
	}
}
