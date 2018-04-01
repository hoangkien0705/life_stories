package com.kienhv.stories.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserAuthToken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String token;
	private int createDate;
	private boolean isExpires;
	
	
	public UserAuthToken() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getCreateDate() {
		return createDate;
	}
	public void setCreateDate(int createDate) {
		this.createDate = createDate;
	}
	public boolean isExpires() {
		return isExpires;
	}
	public void setExpires(boolean isExpires) {
		this.isExpires = isExpires;
	}
	
	
}
