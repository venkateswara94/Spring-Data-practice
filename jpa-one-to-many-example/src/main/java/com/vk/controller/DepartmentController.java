package com.vk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vk.entity.Department;
import com.vk.service.DepartmentService;
 
@RestController
public class DepartmentController {
 
    @Autowired
    private DepartmentService departmentService;
 
    @GetMapping("/get-departments")
    public ResponseEntity<List<Department>> getAllDepartments() {
 
        List<Department> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
 
    @PostMapping("/department")
    public ResponseEntity<Department> saveEmployee(@RequestBody Department department) {
 
    	Department dpt = departmentService.addDepartment(department);
        return new ResponseEntity<>(dpt, HttpStatus.OK);
    }
 
    @PutMapping("/department")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
 
    	Department dept = departmentService.editDepartment(department);
        return new ResponseEntity<>(dept, HttpStatus.OK);
    }
 
    @DeleteMapping("/department")
    public ResponseEntity<String> deleteDepartment(@RequestParam(name = "departmentId") Integer departmentId) {
 
    	departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<>("Department with ID :" + departmentId + " deleted successfully", HttpStatus.OK);
    }
}
