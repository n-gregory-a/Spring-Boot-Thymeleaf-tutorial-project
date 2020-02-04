package com.nga.springboot.springbootthymeleaf.controller;

import com.nga.springboot.springbootthymeleaf.entity.Employee;
import com.nga.springboot.springbootthymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees (Model model) {

        List<Employee> employees = employeeService.findAll();

        // add tj the spring model
        model.addAttribute("employees", employees);

        return "list-employees";
    }

}
