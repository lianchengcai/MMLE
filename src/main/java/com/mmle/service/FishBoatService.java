package com.mmle.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mmle.dao.IFishBoatDao;
import com.mmle.entity.FishBoat;
import com.mmle.serviceImple.IFishBoatService;
import com.mmle.utils.PageUtil;


@Service
public class FishBoatService implements IFishBoatService{

	@Resource
	private IFishBoatDao fishBoatDao;
	
	public boolean add(FishBoat fishBoat){
		if(fishBoatDao.insertFishBoat(fishBoat)==1)return true;
		return false;
	}
	
	public boolean update(FishBoat fishBoat){
		if(fishBoatDao.updateFishBoat(fishBoat)==1)return true;
		return false;
	}
	
	public boolean delete(String boatId){
		if(fishBoatDao.deleteFishBoatById(boatId)==1)return true;
		return false;
	}
	
	public PageUtil<FishBoat> getFishBoatPage(FishBoat fishBoat,int currentPage,int size){
		int count = fishBoatDao.selectFishBoatCount(fishBoat);
		PageUtil<FishBoat> fishBoatPage = new PageUtil<>(currentPage, count, size);
		if(count>0){
			Integer start =  fishBoatPage.getDataStart();
			Integer end = fishBoatPage.getDataEnd();
			List<FishBoat> fishBoatList = fishBoatDao.selectFishBoatByConditions(fishBoat,start, end);
			fishBoatPage.setList(fishBoatList);
			return fishBoatPage;
		}
		return null;
	}
}
