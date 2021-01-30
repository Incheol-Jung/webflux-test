package com.example.webfluxtest.employee.service;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.example.webfluxtest.employee.dao.EmployeeRepository;
import com.example.webfluxtest.employee.entity.Employee;
import com.example.webfluxtest.employee.model.InsertEmployeeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**  * EmployeeService
 *
 * @author incheol.jung
 * @since 2021. 01. 30.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {
	private final EmployeeRepository employeeRepository;

	public List<Employee> get() {
		return employeeRepository.findAll();
	}

	public Employee insert(InsertEmployeeRequest request) {
		log.info("EmployeeService > insert()");
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
		return employeeRepository.save(employee);
	}

	public Mono<Employee> insertWithMono(InsertEmployeeRequest request) {
		log.info("EmployeeService > insertWithMono()");
		return Mono.just(insert(request))
			.publishOn(Schedulers.parallel())
			.subscribeOn(Schedulers.boundedElastic())
			.log();
	}

	private Mono monoConsumer(Consumer consumer) {
		return Mono.just(Mono
			.empty()
			.then()
			.log()
			.publishOn(Schedulers.boundedElastic())
			.doOnSuccess(consumer)
			.subscribe()

		);

	}
}
