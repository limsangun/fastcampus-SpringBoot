package com.study.async.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.async.service.AsyncService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private AsyncService asyncService;
	
	@GetMapping("/hello")
	public CompletableFuture hello() {		
		log.info("completable future init");
		return asyncService.run();
	}
}
