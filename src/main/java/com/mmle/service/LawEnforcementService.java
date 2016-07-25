package com.mmle.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mmle.dao.IExplorationDao;
import com.mmle.dao.ILawEnforcementDao;
import com.mmle.dao.IPenaltyDecisionDao;
import com.mmle.dao.IRecordDao;
import com.mmle.entity.Exploration;
import com.mmle.entity.FishBoat;
import com.mmle.entity.LawEnforcement;
import com.mmle.entity.LawEnforcementExtend;
import com.mmle.entity.PenaltyDecision;
import com.mmle.entity.Record;
import com.mmle.serviceImple.ILawEnforcementService;
import com.mmle.serviceImple.IPenaltyDecisionService;
import com.mmle.utils.PageUtil;

@Service
public class LawEnforcementService implements ILawEnforcementService{

	@Resource
	private ILawEnforcementDao lawEnforcementDao;
	
	@Resource
	private IPenaltyDecisionDao penaltyDecisionDao;
	
	@Resource
	private IRecordDao recordDao;
	
	@Resource
	private IExplorationDao explorationDao;

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Integer add(LawEnforcement lawEnforcement) {
		if(lawEnforcementDao.insertLawEnforcement(lawEnforcement)==1){
			System.out.println("插入成功"+lawEnforcement.getId());
			return lawEnforcement.getId();
		}
		return null;
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

	public PageUtil<LawEnforcementExtend> getLawEnforcementPage(LawEnforcement lawEnforcement, int currentPage, int size) {
		int count = lawEnforcementDao.selectLawEnforcementCount(lawEnforcement);
		
		PageUtil<LawEnforcementExtend> lawEnforcementExtendPage = new PageUtil<>(currentPage, count, size);
		Integer start = lawEnforcementExtendPage.getDataStart();
		int end = lawEnforcementExtendPage.getDataEnd();
		if(count>0){
			List<LawEnforcementExtend> lawEnforcementExtendList = 
					lawEnforcementDao.selectLawEnforcementExtendByConditions(lawEnforcement,start,end );
			for(int i=0;i<lawEnforcementExtendList.size();i++){
				int id = lawEnforcementExtendList.get(i).getId();
				
				PenaltyDecision penaltyDecision = 
						penaltyDecisionDao.selectPenaltyDecisionByLawEnforcementId(id);
				Exploration exploration = explorationDao.selectExplorationByLawEnforcementId(id);
				Record record = recordDao.selectRecordByLawEnforcementId(id);
				
				lawEnforcementExtendList.get(i).setPenaltyDecision(penaltyDecision);
				lawEnforcementExtendList.get(i).setRecord(record);
				lawEnforcementExtendList.get(i).setExploration(exploration);
				
			}
			lawEnforcementExtendPage.setList(lawEnforcementExtendList);
			return lawEnforcementExtendPage;
		}
		return null;
	}
	
//	public PageUtil<LawEnforcement> getLawEnforcementPage(LawEnforcement lawEnforcement, int currentPage, int size) {
//		int count = lawEnforcementDao.selectLawEnforcementCount(lawEnforcement);
//		PageUtil<LawEnforcement> lawEnforcementPage = new PageUtil<>(currentPage, count, size);
//		if(count>0){
//			List<LawEnforcement> lawEnforcementList = lawEnforcementDao.selectLawEnforcementByConditions(lawEnforcement, lawEnforcementPage.getDataStart(), lawEnforcementPage.getDataEnd());
//			lawEnforcementPage.setList(lawEnforcementList);
//			return lawEnforcementPage;
//		}
//		return null;
//	}
	
	
}
