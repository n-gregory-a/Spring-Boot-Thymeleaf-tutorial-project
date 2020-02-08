package com.nga.springboot.springbootthymeleaf.dao;

import com.nga.springboot.springbootthymeleaf.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {

    // method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
    
}
