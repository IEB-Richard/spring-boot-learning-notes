package com.springboot.chapter6.entity;

public class User {
	private Long id;
	private String userName;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", note=" + note + "]";
	}
	
}