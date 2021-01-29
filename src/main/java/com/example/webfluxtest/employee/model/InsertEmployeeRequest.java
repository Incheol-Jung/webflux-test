package com.example.webfluxtest.employee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**  * InsertEmployeeRequest
 *
 * @author incheol.jung
 * @since 2021. 01. 29.
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
public class InsertEmployeeRequest {
	private String name;
	private String email;
	private String phoneNumber;
}
