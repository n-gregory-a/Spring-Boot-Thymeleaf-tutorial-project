package com.nga.springboot.springbootthymeleaf.controller;

import com.nga.springboot.springbootthymeleaf.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // load employee data
    private List<Employee> employees;

    @PostConstruct
    private void loadData() {

        // create employees
        Employee employee1 = new Employee(1, "Leslie", "Andrews", "leslie@gmail.com");
        Employee employee2 = new Employee(2, "Emma", "Baumgarten", "emma@gmail.com");
        Employee employee3 = new Employee(3, "Avani", "Gupta", "avani@gmail.com");

        // create the list
        employees = new ArrayList<>();

        // add to the list
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees (Model model) {

        // add tj the spring model
        model.addAttribute("employees", employees);

        return "list-employees";
    }

}
