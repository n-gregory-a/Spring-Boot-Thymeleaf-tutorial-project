package com.nga.springboot.springbootthymeleaf.controller;

import com.nga.springboot.springbootthymeleaf.entity.Employee;
import com.nga.springboot.springbootthymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

        // add to the spring model
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        // create model attribute to bind form data
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    private String saveEmployee(@ModelAttribute("employee") Employee employee) {

        // save the employee
        employeeService.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

}
