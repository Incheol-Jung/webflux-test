// package com.example.webfluxtest.employee.service;
//
// import java.util.function.Consumer;
//
// import org.springframework.stereotype.Service;
//
// import com.example.webfluxtest.employee.entity.Employee;
// import com.example.webfluxtest.employee.model.InsertEmployeeRequest;
// import com.example.webfluxtest.employee.reactive.EmployeeR2dbcRepository;
// import lombok.RequiredArgsConstructor;
// import reactor.core.publisher.Flux;
// import reactor.core.publisher.Mono;
//
// /**  * ReactiveEmployeeService
//  *
//  * @author incheol.jung
//  * @since 2021. 01. 28.
//  */
// @Service
// @RequiredArgsConstructor
// public class ReactiveEmployeeService {
// 	private final EmployeeR2dbcRepository employeeR2dbcRepository;
//
// 	public Mono<Employee> insertWithR2dbcRepository(InsertEmployeeRequest request) {
// 		Employee employee = Employee.builder()
// 			.name(request.getName())
// 			.email(request.getEmail())
// 			.phoneNumber(request.getPhoneNumber())
// 			.build();
//
// 		return employeeR2dbcRepository.save(employee);
// 	}
//
// 	private Mono monoConsumer(Consumer consumer) {
// 		return Mono.just(Mono
// 			.empty()
// 			.then()
// 			.doOnSuccess(consumer)
// 			.subscribe());
// 	}
//
// 	public Flux<Employee> get() {
// 		return employeeR2dbcRepository.findAll();
// 	}
// }
