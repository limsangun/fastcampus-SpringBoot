package com.study.validation.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.study.validation.annotation.YearMonth;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class User {

	@NotBlank
	private String name;
	
	@Max(value = 90)
	private int age;
	
	@Email
	private String email;
	
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. ex)01x-xxx(x)-xxxx")
	private String phoneNumber;
	
	@YearMonth
	private String reqYearMonth;	//yyyyMM

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getReqYearMonth() {
		return reqYearMonth;
	}

	public void setReqYearMonth(String reqYearMonth) {
		this.reqYearMonth = reqYearMonth;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", reqYearMonth=" + reqYearMonth + "]";
	}

	
	
}
