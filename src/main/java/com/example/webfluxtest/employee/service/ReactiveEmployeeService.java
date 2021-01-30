package com.example.webfluxtest.employee.service;

import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.example.webfluxtest.employee.entity.Employee;
import com.example.webfluxtest.employee.model.InsertEmployeeRequest;
import com.example.webfluxtest.employee.reactive.EmployeeR2dbcRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**  * ReactiveEmployeeService
 *
 * @author incheol.jung
 * @since 2021. 01. 28.
 */
@Service
@RequiredArgsConstructor
public class ReactiveEmployeeService {
	// private final EmployeeService employeeService;

	private final EmployeeR2dbcRepository employeeR2dbcRepository;

	// public Mono<Employee> insertWithService(InsertEmployeeRequest request) {
	// 	return monoConsumer(o -> employeeService.insert(request));
	// }

	public Mono<Employee> insertWithR2dbcRepository(InsertEmployeeRequest request) {
		Employee employee = Employee.builder()
			.name(request.getName())
			.email(request.getEmail())
			.phoneNumber(request.getPhoneNumber())
			.build();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return Mono.just(employeeR2dbcRepository.save(employee).block())
			.publishOn(Schedulers.parallel())
			.subscribeOn(Schedulers.boundedElastic());
	}

	private Mono monoConsumer(Consumer consumer) {
		return Mono.just(Mono
			.empty()
			.then()
			.doOnSuccess(consumer)
			.subscribe());
	}

}
