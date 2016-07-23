package com.mmle.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mmle.dao.IPenaltyDecisionDao;
import com.mmle.serviceImple.IPenaltyDecisionService;

@Service
public class PenaltyDecisionService implements IPenaltyDecisionService{

	@Resource
	private IPenaltyDecisionDao penaltyDecisionDao;
}
