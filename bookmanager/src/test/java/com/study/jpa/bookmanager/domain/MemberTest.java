package com.study.jpa.bookmanager.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

class MemberTest {

	@Test
	void test() {
		//@NoArgsConstructor
		Member user = new Member();
		user.setEmail("martin@fastcampus.com");
		user.setName("martin");
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		
		//@AllArgsConstructor
		//Member user1 = new Member(null, "martin", "martin@fastcampus.com", LocalDateTime.now(), LocalDateTime.now());
		//@RequiredArgsConstructor
		Member user2 = new Member("martin", "martin@fastcampus.com");
		//@Builder
		Member user3 = Member.builder()
				.name("martin")
				.email("martin@fastcampus.com")
				.build();
		
		System.out.println(">>> " + user);
	}

}
