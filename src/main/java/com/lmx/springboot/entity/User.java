package com.lmx.springboot.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	private String username;
	private String password;
	//@JSONField(format="yyyy-dd-mm")
	private Date birthday;
	
	public User(String username, String password, Date birthday) {
		super();
		this.username = username;
		this.password = password;
		this.birthday = birthday;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
}
