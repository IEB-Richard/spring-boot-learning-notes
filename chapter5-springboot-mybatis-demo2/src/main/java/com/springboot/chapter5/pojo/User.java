package com.springboot.chapter5.pojo;

import org.apache.ibatis.type.Alias;

import com.springboot.chapter5.enumeration.SexEnum;

@Alias(value = "user")// MyBatis指定别名
public class User {
	
	private Long id = null;
	private String userName = null;
	private SexEnum sex = null;
	private String note = null;
	
	public User() {
	}

	public User(Long id, String userName, String note, SexEnum sex) {
		this.id = id;
		this.userName = userName;
		this.note = note;
		this.sex = sex;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}
	
}
