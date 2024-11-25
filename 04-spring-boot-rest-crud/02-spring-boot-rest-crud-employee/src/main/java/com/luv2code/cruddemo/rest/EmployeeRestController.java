package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.entity.Employee;
import com.luv2code.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeServie;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeServie = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeServie.findAll();
    }

    // add mapping for GET /employee/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee theEmployee = employeeServie.findById(employeeId);

        if(theEmployee == null) {
            throw new RuntimeException("Employee not Found! -> " + employeeId);
        }
        return theEmployee;
    }

    // add mapping for POST /employees - add new employee
   @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);

        Employee dbEmployee = employeeServie.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for PUT /employees - update the existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeServie.save(theEmployee);
        return dbEmployee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete the employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeServie.findById(employeeId);

        if(theEmployee == null) {
            throw new RuntimeException("Employee id not Found! -> " + employeeId);
        }
        employeeServie.deleteById(employeeId);
        return "Employee deleted! -> " + employeeId;
    }
}
