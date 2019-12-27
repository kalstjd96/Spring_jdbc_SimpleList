package com.jang.biz.model;

import javax.validation.constraints.NotEmpty;

public class Card {
	
	private int bno;
	@NotEmpty(message="이름이 입력되지 않았습니다!")
	private String bname;
	@NotEmpty(message="전화번호가 입력되지 않았습니다!")
	private String phone;
	@NotEmpty(message = "설명이 입력되지 않았습니다.")
	private String description;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
