package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.errors.EmployeeNotFoundException;
import com.example.demo.models.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeController(EmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping("/employees")
	public List <Employee> all(){
		return employeeRepository.findAll();
	}
	
	@PostMapping("/employees")
	public Employee newEmployee(@RequestBody Employee newEmployee) {
		return employeeRepository.save(newEmployee);
	}
	
	//SINGLE ITEM
	@GetMapping("/employees/{id}")
	public Employee one(@PathVariable Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(()-> new EmployeeNotFoundException(id));
	}
	
	//REPLACE A EMPLOYEE
	@PutMapping("/employees/{id}")
	public Employee replaceEmployee(@RequestBody Employee newEmployee, Long id) {
		return employeeRepository.findById(id)
				.map(employee -> {
					employee.setName(newEmployee.getName());
					employee.setRole(newEmployee.getRole());
					return employeeRepository.save(employee);
				})
				.orElseGet(()->{
					newEmployee.setId(id);
					return employeeRepository.save(newEmployee);
				});
	}
	
	//DELETING AN EMPLOYEE
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeRepository.deleteById(id);
	}

}
