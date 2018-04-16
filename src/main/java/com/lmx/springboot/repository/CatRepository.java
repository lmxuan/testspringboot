package com.lmx.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.lmx.springboot.entity.Cat;

public interface CatRepository extends CrudRepository<Cat, Integer>{

}
