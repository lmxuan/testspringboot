package com.lmx.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lmx.springboot.entity.Cat;
import com.lmx.springboot.service.CatService;

@RestController
@RequestMapping("/cat")
public class CatController {
	@Autowired
	private CatService service;
	
	@RequestMapping("/save")
	public void save(){
		Cat cat = new Cat();
		cat.setCatAge(10);
		cat.setCatName("tom");
		service.save(cat);
	}
	
	@RequestMapping("/delete")
	public void delete(int id){
		service.delete(id);
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	public Iterable<Cat> getAll(){
		return service.getAll();
	}
}
