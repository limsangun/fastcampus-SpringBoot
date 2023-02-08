package com.study.exception.advice;

import java.lang.reflect.Field;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.study.exception.controller.ApiController;
import com.study.exception.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;

@RestControllerAdvice(basePackageClasses = ApiController.class)
public class ApiControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity exception(Exception e) {
		System.out.println(e.getClass().getName());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest) {
		
		List<com.study.exception.dto.Error> errorList = new ArrayList<>();
		
		BindingResult bindingResult = e.getBindingResult();
		
		bindingResult.getAllErrors().forEach(error -> {
			FieldError field = (FieldError) error;
			
			String fieldName = field.getField();
			String message = field.getDefaultMessage();
			String value = field.getRejectedValue().toString();
			
			com.study.exception.dto.Error errorMsg = new com.study.exception.dto.Error();
			errorMsg.setField(fieldName);
			errorMsg.setMessage(message);
			errorMsg.setInvalidValue(value);
			
			errorList.add(errorMsg);
		});
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorList(errorList);
		errorResponse.setMessage("");
		errorResponse.setRequestUrl(httpServletRequest.getRequestURL());
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
		errorResponse.setResultCode("FAIL");
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity constraintViolationException(ConstraintViolationException e, HttpServletRequest httpServletRequest) {
		
		List<com.study.exception.dto.Error> errorList = new ArrayList<>();
		
		e.getConstraintViolations().forEach(error -> {
			
			Stream<Path.Node> stream = StreamSupport.stream(error.getPropertyPath().spliterator(), false);
			List<Path.Node> list = stream.collect(Collectors.toList());
			
			String field = list.get(list.size()-1).getName();
			String message = error.getMessage();
			String invalidValue = error.getInvalidValue().toString();
						
			com.study.exception.dto.Error errorMsg = new com.study.exception.dto.Error();
			errorMsg.setField(field);
			errorMsg.setMessage(message);
			errorMsg.setInvalidValue(invalidValue);
			
			errorList.add(errorMsg);
		});
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorList(errorList);
		errorResponse.setMessage("");
		errorResponse.setRequestUrl(httpServletRequest.getRequestURL());
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
		errorResponse.setResultCode("FAIL");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e, HttpServletRequest httpServletRequest) {				
		
		List<com.study.exception.dto.Error> errorList = new ArrayList<>();
		
		String fieldName = e.getParameterName();
		String fieldType = e.getParameterType();
		String invalidValue = e.getMessage();
		
		com.study.exception.dto.Error errorMsg = new com.study.exception.dto.Error();
		errorMsg.setField(fieldName);
		errorMsg.setMessage(invalidValue);
		
		errorList.add(errorMsg);
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorList(errorList);
		errorResponse.setMessage("");
		errorResponse.setRequestUrl(httpServletRequest.getRequestURL());
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
		errorResponse.setResultCode("FAIL");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}
