package com.study.jpa.bookmanager.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.jpa.bookmanager.domain.Book;

@SpringBootTest
class BookRepositoryTest {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	void bookTest() {
		Book book = new Book();
		book.setName("Jpa 초격차 패키지");
		book.setAuthorId(1L);
//		book.setPublisherId(1L);
		
		bookRepository.save(book);
		
		System.out.println(bookRepository.findAll());
	}

}
