package com.study.springcalculator.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.springcalculator.component.Calculator;
import com.study.springcalculator.component.DollarCalculator;
import com.study.springcalculator.component.ICalculator;
import com.study.springcalculator.component.MarketApi;
import com.study.springcalculator.dto.Req;

@WebMvcTest(CalculatorApiController.class)
@AutoConfigureWebMvc
@Import({Calculator.class, DollarCalculator.class})
public class CalculatorApiControllerTest {

	@MockBean
	private MarketApi marketApi;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	public void init() {
		Mockito.when(marketApi.connect()).thenReturn(3000);
	}
	
	@Test
	public void sumTest() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.get("http://localhost:8080/api/sum")
						.queryParam("x", "10")
						.queryParam("y", "10")				
				).andExpect(
						MockMvcResultMatchers.status().isOk()
				).andExpect(
						MockMvcResultMatchers.content().string("60000")					
				).andDo(MockMvcResultHandlers.print());
		
	}
	
	@Test
	public void minusTest() throws Exception {
		Req req = new Req();
		req.setX(10);
		req.setY(10);
		
		String json = new ObjectMapper().writeValueAsString(req);
		
		mockMvc.perform(
				MockMvcRequestBuilders.post("http://localhost:8080/api/minus")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				).andExpect(
						MockMvcResultMatchers.status().isOk()
				).andExpect(
						MockMvcResultMatchers.jsonPath("$.result").value("0")
				).andExpect(
						MockMvcResultMatchers.jsonPath("$.response.resultCode").value("OK")
				).andDo(MockMvcResultHandlers.print());
		
	}
}













