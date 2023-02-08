package com.study.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.exception.dto.User;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/api/user")
@Validated
public class ApiController {

	@GetMapping
	public User get(
			@Size(min = 2)
			@RequestParam String name,
			
			@NotNull
			@Min(1)
			@RequestParam Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		
		//int a = 10+age;
		
		return user;
	}
	
	@PostMapping
	public User post(@Valid @RequestBody User user) {
		System.out.println(user);
		
		return user;
	}
	
	
	//class내에 코드 작성하면 우선순위1등
//	@ExceptionHandler(value = MethodArgumentNotValidException.class)
//	public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
//		System.out.println("api controller");
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//	}
}
