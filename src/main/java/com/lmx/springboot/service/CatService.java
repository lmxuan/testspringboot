package com.lmx.springboot.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lmx.springboot.entity.Cat;
import com.lmx.springboot.repository.CatRepository;

@Service
public class CatService {
	@Resource
	private CatRepository catRepository;
	
	@Transactional
	public void save(Cat cat){
		catRepository.save(cat);
	}
	
	@Transactional
	public void delete(int id){
		catRepository.delete(id);
	}
	
	public Iterable<Cat> getAll(){
		return catRepository.findAll();
	}
}
