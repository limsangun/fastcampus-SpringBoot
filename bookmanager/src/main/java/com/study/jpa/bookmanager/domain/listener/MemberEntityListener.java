package com.study.jpa.bookmanager.domain.listener;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

import com.study.jpa.bookmanager.domain.Member;
import com.study.jpa.bookmanager.domain.MemberHistory;
import com.study.jpa.bookmanager.repository.MemberHistoryRepository;
import com.study.jpa.bookmanager.support.BeanUtils;

public class MemberEntityListener {
	
	@PostPersist
	@PostUpdate
	public void prePersistAndPreUpdate(Object o) {
		MemberHistoryRepository memberHistoryRepository = BeanUtils.getBean(MemberHistoryRepository.class);
		
		Member member = (Member) o;
		
		MemberHistory memberHistory = new MemberHistory();
		memberHistory.setName(member.getName());
		memberHistory.setEmail(member.getEmail());
		memberHistory.setMember(member);
		
		memberHistoryRepository.save(memberHistory);
	}
}
