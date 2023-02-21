package com.study.jpa.bookmanager.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.jpa.bookmanager.domain.Gender;
import com.study.jpa.bookmanager.domain.Member;
import com.study.jpa.bookmanager.domain.MemberHistory;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
class MemberRepositoryTest {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberHistoryRepository memberHistoryRepository;
	
	@Test
	void crud() {
		memberRepository.save(new Member("david", "david@fastcampus.com"));
		
		Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
		member.setEmail("martin-updated@fastcampus.com");
		
		memberRepository.save(member);
		
		memberRepository.findAll().forEach(System.out::println);
	}
	
	@Test
	void select() {
		System.out.println(memberRepository.findByName("martin"));
	}
	
	@Test
	void insertAndUpdateTest() {
		Member member = new Member();
		member.setName("martin");
		member.setEmail("martin2@fastcampus.com");
		
		memberRepository.save(member);
		
		Member member2 = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
		member2.setName("marrrrrrrtin");
		
		memberRepository.save(member2);
		
	}
	
	@Test
	void listenerTest() {
		Member member = new Member();
		member.setEmail("martin2@fastcampus.com");
		member.setName("martin");
		
		memberRepository.save(member);
		
		Member member2 = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
		member2.setName("marrrrrtin");
		
		memberRepository.save(member2);
		
		memberRepository.deleteById(4L);
	}

	@Test
	void prePersistTest() {
		Member member = new Member();
		member.setEmail("martin2@fastcampus.com");
		member.setName("martin");
//		member.setCreatedAt(LocalDateTime.now());
//		member.setUpdatedAt(LocalDateTime.now());
		
		memberRepository.save(member);
		
		System.out.println(memberRepository.findByEmail("martin2@fastcampus.com"));
		
	}
	
	@Test
	void preUpdateTest() {
		Member member = memberRepository.findById(1L).orElseThrow(RuntimeException::new);
		
		System.err.println("as-is : " + member);
		
		member.setName("martin22");
		memberRepository.save(member);
		
		System.out.println("to-be : "+ memberRepository.findAll().get(0));
		
	}
	
	@Test
	void memberHistoryTest() {
		Member member = new Member();
		member.setEmail("martin-new@fastcampus.com");
		member.setName("martin");
		memberRepository.save(member);
		
		member.setName("martin-new-new");
		memberRepository.save(member);
		
		memberHistoryRepository.findAll().forEach(System.out::println);
	}
	
	@Test 
	void userRelationTest() {
		Member member = new Member();
		member.setName("david");
		member.setEmail("david@fastcampus.com");
		member.setGender(Gender.MALE);
		memberRepository.save(member);
		
		member.setName("daniel");
		memberRepository.save(member);
		
		member.setEmail("daniel@fastcampus.com");		
		memberRepository.save(member);
		
//		List<MemberHistory> result = memberHistoryRepository.findByMemberId(memberRepository.findByEmail("daniel@fastcampus.com").getId());
		
		List<MemberHistory> result = memberRepository.findByEmail("daniel@fastcampus.com").getMemberHistories();
		
		result.forEach(System.out::println);
	}
}
