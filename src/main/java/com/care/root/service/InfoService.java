package com.care.root.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.care.root.dto.InfoDto;

@Service
public class InfoService {
	
	Map<String, InfoDto> DB;
	ArrayList<InfoDto> list;
	
	public InfoService() {
		
		DB = new HashMap<String, InfoDto>();
		list = new ArrayList<InfoDto>();
		
		for(int i=0; i<5; i++) {
			InfoDto dto = new InfoDto();
			
			dto.setName("¾ÞµÎ"+i);
			dto.setAge(i);
			
			list.add(dto);
			DB.put("¾ÞµÎ"+i, dto);
		}
	}//infoService
	
	public List<InfoDto> getList(){
		//select * from [table]
		return list;
	}//getList
	
	public InfoDto getUser(String id) {
		//select * from [table] where id = id
		return DB.get(id);
	}//getUser
	
	public int modify(InfoDto dto) {
		//update~
		DB.replace(dto.getName(), dto);
			
		return 1;
	}
	
	public int insert(InfoDto dto) {
		DB.put(dto.getName(), dto);
		list.add(dto);
		
		return 1;
	}
	
	public void delete(String uId) {
		DB.remove(uId);
		for(int i=0; i<list.size(); i++) {
			InfoDto dto = list.get(i);
			if(dto.getName().equals(uId))
				list.remove(i);
		}
	}
}
