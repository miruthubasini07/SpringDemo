package com.example.SpringDemo.rest;

import com.example.SpringDemo.entity.Employee;
import com.example.SpringDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/ping")
    public String ping(){
        return "Server Available";
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("employee/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee not found");
        }
        return employee;
    }

    @PostMapping("employee")
    public Employee createEmployee(@RequestBody Employee employee){
        employee.setId(0);//Setting ID as 0 to create a new Objetct. It will create a new ID from Database
        return employeeService.save(employee);
    }
    @PutMapping("employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        if(employee.getId() == 0){
            throw new RuntimeException("Id is Required to update the Employee");
        }
        return employeeService.save(employee);
    }

    @DeleteMapping("employee/{employeeId}")
    public String deleteById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee not found");
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee Sucessfully!";
    }
}
