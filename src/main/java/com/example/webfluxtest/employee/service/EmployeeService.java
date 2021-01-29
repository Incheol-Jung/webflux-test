// package com.example.webfluxtest.employee.service;
//
// import java.util.List;
//
// import org.springframework.stereotype.Service;
//
// import com.example.webfluxtest.employee.dao.EmployeeRepository;
// import com.example.webfluxtest.employee.entity.Employee;
// import com.example.webfluxtest.employee.model.InsertEmployeeRequest;
// import lombok.RequiredArgsConstructor;
//
// /**  * EmployeeService
//  *
//  * @author incheol.jung
//  * @since 2021. 01. 29.
//  */
// @Service
// @RequiredArgsConstructor
// public class EmployeeService {
// 	private final EmployeeRepository employeeRepository;
//
// 	public Employee insert(InsertEmployeeRequest request) {
// 		Employee employee = Employee.builder()
// 			.name(request.getName())
// 			.email(request.getEmail())
// 			.phoneNumber(request.getPhoneNumber())
// 			.build();
//
// 		return employeeRepository.save(employee);
// 	}
//
// 	public List<Employee> get() {
// 		return employeeRepository.findAll();
// 	}
// }
