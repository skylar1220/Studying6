package com.lee.testproject.dao.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.testproject.dao.ItemDao;
import com.lee.testproject.dao.MemberServiceDao;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberServiceDao memberServiceDao ; 

	@Override
	public boolean getMember(Map<String, Object> map) {
		return memberServiceDao.getMember(map);
	}
	


	
//	@Override
//	public String insert(Map<String, Object> map) {
//		if(itemDao.insert(map) == 1)
//			return map.get("id").toString();
//		return null;
//	}
//	
//	@Override
//	public List<Map<String, Object>> selectAll(){
//		return itemDao.selectAll();
//	}
//
//	@Override
//	public Map<String, Object> detail(Map<String, Object> map) {
//			
//		return itemDao.detail(map);
//	}
//
//	@Override
//	public boolean update(Map<String, Object> map) {
//		return itemDao.update(map);
//	}
//
//	@Override
//	public void delete(Map<String, Object> map) {
//		itemDao.delete(map);
//		
//	}
}
