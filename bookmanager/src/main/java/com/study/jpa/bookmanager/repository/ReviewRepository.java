package com.study.jpa.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.bookmanager.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
