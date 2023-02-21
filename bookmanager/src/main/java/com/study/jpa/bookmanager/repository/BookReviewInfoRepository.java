package com.study.jpa.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.bookmanager.domain.BookReviewInfo;

public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo, Long>{

}
