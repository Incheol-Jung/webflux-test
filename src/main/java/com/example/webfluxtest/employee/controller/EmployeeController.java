package com.example.webfluxtest.employee.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webfluxtest.employee.entity.Employee;
import com.example.webfluxtest.employee.model.InsertEmployeeRequest;
import com.example.webfluxtest.employee.service.ReactiveEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**  * EmployeeController
 *
 * @author incheol.jung
 * @since 2021. 01. 29.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {
	private final ReactiveEmployeeService reactiveEmployeeService;

	@PostMapping("r2dbcRepository")
	@ResponseBody
	public Mono<Employee> insertWithR2dbcRepository(@RequestBody InsertEmployeeRequest request) {
		log.info("EmployeeController > insertWithR2dbcRepository()");
		return Mono.defer(() -> reactiveEmployeeService.insertWithR2dbcRepository(request))
			.publishOn(Schedulers.parallel())
			.subscribeOn(Schedulers.boundedElastic());
	}
}
