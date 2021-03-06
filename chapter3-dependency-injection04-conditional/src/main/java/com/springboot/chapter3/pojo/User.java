package com.springboot.chapter3.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
public class User {
	
	@Value("1")
	private Long id;
	@Value("user name 1")
	private String userName;
	@Value("note 1")
	private String note;
	
	public User() {
	}

	public User(Long id, String userName, String note) {
		this.id = id;
		this.userName = userName;
		this.note = note;
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
	
	

}
