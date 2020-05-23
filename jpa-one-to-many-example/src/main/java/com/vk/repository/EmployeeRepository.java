package com.vk.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.vk.entity.Employee;
 
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
 
}
