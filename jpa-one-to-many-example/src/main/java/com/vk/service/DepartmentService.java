package com.vk.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.entity.Department;
import com.vk.repository.DepartmentRepository;
 
@Service
public class DepartmentService {
 
    @Autowired
    private DepartmentRepository departmentRepository;
 
     
    public List<Department> getAllDepartments() {
 
        return departmentRepository.findAll();
    }
 
    public Department addDepartment(Department department) {
 
		/*
		 * Department dept =
		 * departmentRepository.findById(department.getId()).orElse(null); if (null ==
		 * dept) { dept = new Department(); }
		 * dept.setDeptName(department.getDeptName()); department.setDepartment(dept);
		 */
        return departmentRepository.save(department);
    }
 
    public Department editDepartment(Department entity) {
 
        return departmentRepository.save(entity);
    }
 
    public void deleteDepartment(Integer id) {
 
        departmentRepository.deleteById(id);
    }
}
