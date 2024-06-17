package com.corso.videoteca.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TestDto {

	private String firstname;
	
	private String lastname;
	
	private int number;

	@Override
	public String toString() {
		return "TestDto [firstname=" + firstname + ", lastname=" + lastname + ", number=" + number + "]";
	}


	
	
	
	
}
