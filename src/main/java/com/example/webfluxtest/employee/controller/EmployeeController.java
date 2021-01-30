package com.example.webfluxtest.employee.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webfluxtest.employee.model.InsertEmployeeRequest;
import com.example.webfluxtest.employee.service.ReactiveEmployeeService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

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
	private final ReactiveEmployeeService reactiveEmployeeService;

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
	@PostMapping("r2dbcRepository")
	@ResponseBody
	public Mono<ResponseEntity> insertWithR2dbcRepository(@RequestBody InsertEmployeeRequest request) {
		return Mono.just(
			new ResponseEntity(
				reactiveEmployeeService.insertWithR2dbcRepository(request).subscribeOn(Schedulers.boundedElastic()),
				HttpStatus.ACCEPTED));
	}
}
