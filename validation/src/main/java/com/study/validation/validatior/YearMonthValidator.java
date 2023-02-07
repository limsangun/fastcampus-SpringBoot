package com.study.validation.validatior;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.study.validation.annotation.YearMonth;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String>{

	private String pattern;
	
	@Override
	public void initialize(YearMonth constraintAnnotation) {
		this.pattern = constraintAnnotation.pattern();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// yyyyMM
		try {
			LocalDate localDate = LocalDate.parse(value+"01", DateTimeFormatter.ofPattern(this.pattern));			
		} catch(Exception e) {
			return false;
		}
		
		return true;
	}

}
