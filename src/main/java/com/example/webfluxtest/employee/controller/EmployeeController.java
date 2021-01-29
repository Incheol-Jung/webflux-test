package com.example.webfluxtest.employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

// import com.example.webfluxtest.employee.service.ReactiveEmployeeService;

/**  * EmployeeController
 *
 * @author incheol.jung
 * @since 2021. 01. 29.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {
	// private final EmployeeService employeeService;
	// private final ReactiveEmployeeService reactiveEmployeeService;

	// @GetMapping
	// public ResponseEntity<List<Employee>> get() {
	// 	return new ResponseEntity(employeeService.get(), HttpStatus.OK);
	// }
	//
	// @PostMapping
	// public ResponseEntity<Employee> insert(@RequestBody InsertEmployeeRequest request) {
	// 	return new ResponseEntity(employeeService.insert(request), HttpStatus.ACCEPTED);
	// }

	// @PostMapping("reactiveService")
	// @ResponseBody
	// public Mono<ResponseEntity> insertWithService(@RequestBody InsertEmployeeRequest request) {
	// 	return Mono.just(new ResponseEntity(reactiveEmployeeService.insertWithService(request), HttpStatus.ACCEPTED));
	// }
	//
	// @PostMapping("r2dbcRepository")
	// @ResponseBody
	// public Mono<ResponseEntity> insertWithR2dbcRepository(@RequestBody InsertEmployeeRequest request) {
	// 	return Mono.just(
	// 		new ResponseEntity(reactiveEmployeeService.insertWithR2dbcRepository(request), HttpStatus.ACCEPTED));
	// }
}
