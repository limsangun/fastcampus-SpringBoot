package com.study.jpa.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.bookmanager.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
