package com.study.jpa.bookmanager.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.bookmanager.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	Set<Member> findByName(String name);
	
	List<Member> findByCreatedAtAfter(LocalDateTime localDateTime);
	
	Member findByEmail(String email);
}
