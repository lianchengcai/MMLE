package com.mmle.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mmle.dao.IExplorationDao;
import com.mmle.serviceImple.IExplorationService;

@Service
public class ExplorationService implements IExplorationService{

	@Resource
	private IExplorationDao explorationDao;
}
