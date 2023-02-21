package com.study.jpa.bookmanager.domain.listener;

import java.time.LocalDateTime;

public interface Auditable {

	LocalDateTime getCreatedAt();
	LocalDateTime getUpdatedAt();
	
	void setCreatedAt(LocalDateTime createdAt);
	void setUpdatedAt(LocalDateTime updatedAt);
}