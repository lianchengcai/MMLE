package com.mmle.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mmle.dao.CaseDao;
import com.mmle.dao.IExplorationDao;
import com.mmle.dao.ILawEnforcementDao;
import com.mmle.dao.IPenaltyDecisionDao;
import com.mmle.dao.IRecordDao;
import com.mmle.entity.Case;
import com.mmle.entity.Exploration;
import com.mmle.entity.LawEnMessage;
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
	private CaseDao caseDao;
	
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
		System.out.println(lawEnforcement.toString());
		int count = lawEnforcementDao.selectLawEnforcementCount(lawEnforcement);
		PageUtil<LawEnforcementExtend> lawEnforcementExtendPage = new PageUtil<>(currentPage, count, size);
		Integer start = lawEnforcementExtendPage.getDataStart();
		int end = lawEnforcementExtendPage.getDataEnd();
		if(count>0){
			List<LawEnforcementExtend> lawEnforcementExtendList = 
					lawEnforcementDao.selectLawEnforcementExtendByConditions(lawEnforcement,start,size );
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

	public PageUtil<LawEnMessage> getLawEnMessagePage(LawEnMessage lawEnMessage, Integer currentPage, Integer size) {
		System.out.println("fassad");
		int count = lawEnforcementDao.selectLawEnMessageCount(lawEnMessage);
		System.out.println("fas");
		PageUtil<LawEnMessage> lawEnMessagePage = new PageUtil<>(currentPage, count, size);
		Integer start = lawEnMessagePage.getDataStart();
		int end = lawEnMessagePage.getDataEnd();
		if(count>0){
			System.out.println("我执行到这里！");
			System.out.println(size);
			List<LawEnMessage> list = lawEnforcementDao.selectLawEnMessageByConditions(lawEnMessage, start, size);
			System.out.println("我执行到这里！！！"+count);
			for(int i=0;i<list.size();i++){
				int id = list.get(i).getId();
				Case cas =  caseDao.getCaseByCaseId(list.get(i).getCaseId());
				list.get(i).setCasName(cas.getCaseName());
				System.out.println(cas);
				Record record = recordDao.selectRecordByLawEnforcementId(id);
				PenaltyDecision penaltyDecision = 
						penaltyDecisionDao.selectPenaltyDecisionByLawEnforcementId(id);
				Exploration exploration = explorationDao.selectExplorationByLawEnforcementId(id);
				if(record==null){
					list.get(i).setRecord(false);
				}else{
					list.get(i).setRecord(true);
				}
				if(penaltyDecision==null){
					list.get(i).setPenaltyDecision(false);
				}else{
					list.get(i).setPenaltyDecision(true);
				}
				if(exploration==null){
					list.get(i).setExploration(false);
				}else{
					list.get(i).setExploration(true);
				}
				
			}
			if(list!=null){
				lawEnMessagePage.setList(list);
			}
		}
		
		return lawEnMessagePage;
	}

	public PageUtil<LawEnMessage> getLawEnMessagePage(LawEnMessage lawEnMessage, Integer currentPage, Integer size,
			Date lawStartTime, Date lawEndTime) {
		System.out.println("fassad");
		int count = lawEnforcementDao.selectLEPageByTimeCount(lawEnMessage,lawStartTime,lawEndTime);
		System.out.println("fas");
		PageUtil<LawEnMessage> lawEnMessagePage = new PageUtil<>(currentPage, count, size);
		Integer start = lawEnMessagePage.getDataStart();
		int end = lawEnMessagePage.getDataEnd();
		if(count>0){
			System.out.println("我执行到这里！");
			System.out.println(size);
			List<LawEnMessage> list = 
					lawEnforcementDao.selectLEPageByTimeByConditions(
							lawEnMessage,start,size,lawStartTime,lawEndTime);
			System.out.println("我执行到这里！！！"+count);
			for(int i=0;i<list.size();i++){
				int id = list.get(i).getId();
				Case cas =  caseDao.getCaseByCaseId(list.get(i).getCaseId());
				list.get(i).setCasName(cas.getCaseName());
				System.out.println(cas);
				Record record = recordDao.selectRecordByLawEnforcementId(id);
				PenaltyDecision penaltyDecision = 
						penaltyDecisionDao.selectPenaltyDecisionByLawEnforcementId(id);
				Exploration exploration = explorationDao.selectExplorationByLawEnforcementId(id);
				if(record==null){
					list.get(i).setRecord(false);
				}else{
					list.get(i).setRecord(true);
				}
				if(penaltyDecision==null){
					list.get(i).setPenaltyDecision(false);
				}else{
					list.get(i).setPenaltyDecision(true);
				}
				if(exploration==null){
					list.get(i).setExploration(false);
				}else{
					list.get(i).setExploration(true);
				}
				
			}
			if(list!=null){
				lawEnMessagePage.setList(list);
			}
		}
		
		return lawEnMessagePage;
	}
	
	
//	public PageUtil<LawEnforcementExtend> getLawEnforcementPage(LawEnforcement lawEnforcement, Integer currentPage,
//			Integer size, Date lawStartTime, Date lawEndTime) {
//		System.out.println(lawEnforcement.toString());
//		int count = lawEnforcementDao.selectLEPageByTimeCount(lawEnforcement,lawStartTime,lawEndTime);
//		PageUtil<LawEnforcementExtend> lawEnforcementExtendPage = new PageUtil<>(currentPage, count, size);
//		Integer start = lawEnforcementExtendPage.getDataStart();
//		if(count>0){
//			List<LawEnforcementExtend> lawEnforcementExtendList = 
//					lawEnforcementDao.selectLEPageByTimeByConditions(lawEnforcement,start,size,lawStartTime,lawEndTime);
//			for(int i=0;i<lawEnforcementExtendList.size();i++){
//				int id = lawEnforcementExtendList.get(i).getId();
//				
//				PenaltyDecision penaltyDecision = 
//						penaltyDecisionDao.selectPenaltyDecisionByLawEnforcementId(id);
//				Exploration exploration = explorationDao.selectExplorationByLawEnforcementId(id);
//				Record record = recordDao.selectRecordByLawEnforcementId(id);
//				
//				lawEnforcementExtendList.get(i).setPenaltyDecision(penaltyDecision);
//				lawEnforcementExtendList.get(i).setRecord(record);
//				lawEnforcementExtendList.get(i).setExploration(exploration);
//				
//			}
//			lawEnforcementExtendPage.setList(lawEnforcementExtendList);
//			return lawEnforcementExtendPage;
//		}
//		return null;
//	}
//	
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
