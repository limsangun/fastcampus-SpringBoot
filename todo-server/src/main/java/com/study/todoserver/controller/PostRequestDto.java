package com.study.todoserver.controller;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

public class PostRequestDto {

	private String account;
	private String email;
	private String address;
	private String password;
	private String phone_number; // phone_number
	private String OTP;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getOTP() {
		return OTP;
	}
	public void setOTP(String OTP) {
		this.OTP = OTP;
	}
	@Override
	public String toString() {
		return "PostRequestDto [account=" + account + ", email=" + email + ", address=" + address + ", password="
				+ password + ", phone_number=" + phone_number + ", OTP=" + OTP + "]";
	}
	
	
	
}
