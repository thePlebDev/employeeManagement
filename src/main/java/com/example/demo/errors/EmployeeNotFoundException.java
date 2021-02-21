package com.example.demo.errors;

public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(Long id) {
		super("could not find employee " + id);
	}
}
