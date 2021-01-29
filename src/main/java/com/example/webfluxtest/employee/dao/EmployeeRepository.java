package com.example.webfluxtest.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webfluxtest.employee.entity.Employee;

/**  * EmployeeRepository
 *
 * @author incheol.jung
 * @since 2021. 01. 29.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
