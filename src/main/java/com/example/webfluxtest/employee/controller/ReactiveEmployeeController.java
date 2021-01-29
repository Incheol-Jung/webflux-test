// package com.example.webfluxtest.employee.controller;
//
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
//
// import com.example.webfluxtest.employee.entity.Employee;
// import com.example.webfluxtest.employee.model.InsertEmployeeRequest;
// import com.example.webfluxtest.employee.service.ReactiveEmployeeService;
// import lombok.RequiredArgsConstructor;
// import reactor.core.publisher.Flux;
// import reactor.core.publisher.Mono;
//
// // import com.example.webfluxtest.employee.service.ReactiveEmployeeService;
//
// /**  * EmployeeController
//  *
//  * @author incheol.jung
//  * @since 2021. 01. 29.
//  */
// @RestController
// @RequiredArgsConstructor
// @RequestMapping("employees")
// public class ReactiveEmployeeController {
// 	private final ReactiveEmployeeService reactiveEmployeeService;
//
// 	@GetMapping
// 	public Flux<Employee> get() {
// 		return reactiveEmployeeService.get();
// 	}
//
// 	@PostMapping("r2dbcRepository")
// 	@ResponseBody
// 	public Mono insertWithR2dbcRepository(@RequestBody InsertEmployeeRequest request) {
// 		return reactiveEmployeeService.insertWithR2dbcRepository(request);
// 	}
// }
