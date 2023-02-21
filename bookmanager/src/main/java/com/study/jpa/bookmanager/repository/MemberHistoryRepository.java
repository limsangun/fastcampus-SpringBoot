package com.study.jpa.bookmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.bookmanager.domain.MemberHistory;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Long>{

	List<MemberHistory> findByMemberId(Long memberId);
}
