package com.care.root.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.care.root.dto.InfoDto;
import com.care.root.service.InfoService;

@RestController //jsp는 안돼고, 데이터만 돌려주는 역할
public class AjaxRestController {	
	
	@GetMapping(value = "rest", produces = "application/text; charset=utf-8")
	public String get() {
		return "get 데이터 요청할 때 사용";
	}
	
	@PostMapping(value = "rest", produces = "application/text; charset=utf-8")
	public String post() {
		return "post 데이터 추가";
	}
	 
	@PutMapping(value = "rest", produces = "application/text; charset=utf-8")
	public String put() {
		return "put 데이터 수정";
	}
	
	@DeleteMapping(value = "rest", produces = "application/text; charset=utf-8")
	public String delete() {
		return "delete 데이터 삭제";
	}
	
	@Autowired InfoService is;
	
	@GetMapping(value = "users", produces = "application/json; charset=utf-8")
	public List<InfoDto> users(){
		return is.getList();
	}
	
	@GetMapping(value = "getUser", produces = "application/json; charset-utf-8")
	public InfoDto getUser(@RequestParam String id) {
		return is.getUser(id);
	}
	@GetMapping(value = "getUser/{id}", produces = "application/json; charset-utf-8")
	public InfoDto getUser2(@PathVariable String id) { 
		//@PathVariable어노테이션으로 값ㅅ을 꺼낸옴(이름 같은면 그냥, 다르면 명시)
		//@PathVariable(value="name") String id
		System.out.println("iddd  "+id);
		return is.getUser(id);
	}
	
	@PutMapping(value = "modify", produces = "application/json; charset-utf-8")
	public int modify(@RequestBody InfoDto dto) {
		System.out.println("name: "+dto.getName());
		System.out.println("age: "+dto.getAge());
		int result = is.modify(dto);
		return result;
	}
	
	@PostMapping(value = "insert", produces = "application/json; charset-utf-8")
	public int insert(@RequestBody InfoDto dto) { //Map map
		System.out.println("name: "+dto.getName());
		System.out.println("age: "+dto.getAge());
		int result = is.insert(dto);
		return result;
	}
	
	@DeleteMapping(value = "delete/{uId}", produces = "application/json; charset-utf-8")
	public void delete(@PathVariable String uId) {
		is.delete(uId);
	}
}
