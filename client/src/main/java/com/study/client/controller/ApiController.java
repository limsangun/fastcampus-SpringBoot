package com.study.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.client.dto.Req;
import com.study.client.dto.UserResponse;
import com.study.client.service.RestTemplateService;

@RestController
@RequestMapping("/api/client")
public class ApiController {
		
	private final RestTemplateService restTemplateService;
	
	public ApiController(RestTemplateService restTemplateService) {
		this.restTemplateService = restTemplateService;
	}
	
	@GetMapping("hello")
	public Req<UserResponse> getHello() {
		
		return restTemplateService.genericExchange();
	}

}
