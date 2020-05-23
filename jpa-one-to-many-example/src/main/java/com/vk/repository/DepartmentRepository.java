package com.vk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vk.entity.Department;
 
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
 
}
