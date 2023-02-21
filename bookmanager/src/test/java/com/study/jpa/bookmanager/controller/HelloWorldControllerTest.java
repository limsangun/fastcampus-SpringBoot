package com.study.jpa.bookmanager.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void helloWorld() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello-world"))
			.andDo(print())
			.andExpect(status().isOk());
			
	}

}
