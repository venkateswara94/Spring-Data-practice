package com.vk.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
 
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
@Entity
@Table(name = "Employee_Dtls")
//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode
public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
    @SequenceGenerator(initialValue = 1, name = "emp_seq", sequenceName = "employee_sequence")
    @Column(name = "id")
    private Integer id;
 
    @Column(name = "name")
    private String name;
 
    //@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    //@JoinColumn(foreignKey = @ForeignKey(name = "dept_id"), name = "dept_id")
    @ManyToOne(cascade = CascadeType.ALL,optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
}
