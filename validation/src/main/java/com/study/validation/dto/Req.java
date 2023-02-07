package com.study.validation.dto;

import jakarta.validation.constraints.Size;

public class Req {

	@Size(min = 3)
	private String name;
	
	private String getName() { return name; }
	
	private void setName(String name) { this.name = name; }
}
