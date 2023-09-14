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

@RestController //jsp�� �ȵŰ�, �����͸� �����ִ� ����
public class AjaxRestController {	
	
	@GetMapping(value = "rest", produces = "application/text; charset=utf-8")
	public String get() {
		return "get ������ ��û�� �� ���";
	}
	
	@PostMapping(value = "rest", produces = "application/text; charset=utf-8")
	public String post() {
		return "post ������ �߰�";
	}
	 
	@PutMapping(value = "rest", produces = "application/text; charset=utf-8")
	public String put() {
		return "put ������ ����";
	}
	
	@DeleteMapping(value = "rest", produces = "application/text; charset=utf-8")
	public String delete() {
		return "delete ������ ����";
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
		//@PathVariable������̼����� ������ ������(�̸� ������ �׳�, �ٸ��� ���)
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
