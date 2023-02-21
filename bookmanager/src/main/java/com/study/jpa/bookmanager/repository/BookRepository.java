package com.study.jpa.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.jpa.bookmanager.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
