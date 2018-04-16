package com.lmx.springboot.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lmx.springboot.entity.User;

@RestController
public class UserController {
	
	@RequestMapping("hi")
//	@ResponseBody
	public String hello(HttpServletRequest request){
		String name = request.getParameter("name");
		return  name;
	}
	@RequestMapping("getuser")
	public User getUser(){
		
		return new User("李明轩","1234",new Date());
	}
}
