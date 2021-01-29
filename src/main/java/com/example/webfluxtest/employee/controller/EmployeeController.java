package com.example.webfluxtest.employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webfluxtest.employee.entity.Employee;
import com.example.webfluxtest.employee.model.InsertEmployeeRequest;
import com.example.webfluxtest.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**  * EmployeeController
 *
 * @author incheol.jung
 * @since 2021. 01. 29.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {
	private final EmployeeService employeeService;

	@GetMapping
	public List<Employee> get() {
		return employeeService.get();
	}

	@PostMapping
	@ResponseBody
	public Employee insert(@RequestBody InsertEmployeeRequest request) {
		return employeeService.insert(request);
	}

	@PostMapping("mono")
	@ResponseBody
	public Mono<Employee> insertWithMono(@RequestBody InsertEmployeeRequest request) {
		return employeeService.insertWithMono(request);
	}
}
