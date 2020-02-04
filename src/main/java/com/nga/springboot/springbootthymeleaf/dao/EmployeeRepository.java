package com.nga.springboot.springbootthymeleaf.dao;

import com.nga.springboot.springbootthymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
    
}
