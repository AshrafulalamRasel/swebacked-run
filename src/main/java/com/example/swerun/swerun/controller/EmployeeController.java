package com.example.swerun.swerun.controller;

import com.example.swerun.swerun.Identification;
import com.example.swerun.swerun.dto.request.EmployeeRequest;
import com.example.swerun.swerun.dto.request.EmployeeUpdateRequest;
import com.example.swerun.swerun.dto.response.EmployeeRsponse;
import com.example.swerun.swerun.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Identification createE(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.createEmployee(employeeRequest);
    }

    @GetMapping("/employeeList")
    public List<EmployeeRsponse> listEmployee() {
        return employeeService.getEmployeeList();
    }

    @GetMapping("/{id}")
    public EmployeeRsponse getEmployee(@PathVariable String id) {
        return employeeService.getEmployeeBy(id);
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable String id, @RequestBody EmployeeUpdateRequest employeeUpdateRequest) {
        return employeeService.udateEmpliyeeInfoBy(id, employeeUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployeeBy(id);
    }

}
