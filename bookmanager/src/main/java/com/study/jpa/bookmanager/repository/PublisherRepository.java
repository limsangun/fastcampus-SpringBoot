package com.study.jpa.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.bookmanager.domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long>{

}
