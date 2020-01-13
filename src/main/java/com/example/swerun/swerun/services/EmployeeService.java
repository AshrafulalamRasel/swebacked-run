package com.example.swerun.swerun.services;

import com.example.swerun.swerun.Identification;
import com.example.swerun.swerun.domain.Employee;
import com.example.swerun.swerun.dto.request.EmployeeRequest;
import com.example.swerun.swerun.dto.request.EmployeeUpdateRequest;
import com.example.swerun.swerun.dto.response.EmployeeRsponse;
import com.example.swerun.swerun.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    public Identification createEmployee(EmployeeRequest employeeRequest) {

        UUID id = UUID.randomUUID();
        String uuid = id.toString();

        Employee employee = new Employee();
        employee.setId(uuid);
        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPosition(employeeRequest.getPosition());
        employee.setGender(employeeRequest.getGender());
        employeeRepository.saveAndFlush(employee);
        return new Identification(uuid);
    }

    public List<EmployeeRsponse> getEmployeeList() {

        List<Employee> employeeList = employeeRepository.findAll();

        List<EmployeeRsponse> employeeRsponseList = new ArrayList<>();

        for (Employee employee : employeeList) {
            employeeRsponseList.add(new EmployeeRsponse(employee.getName(), employee.getEmail(), employee.getPosition(), employee.getGender()));
        }


        return employeeRsponseList;

    }

    public EmployeeRsponse getEmployeeBy(String id) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (!employeeOptional.isPresent()) {
            //TODO
        }

        Employee employee = employeeOptional.get();
        return EmployeeRsponse.builder()
                .name(employee.getName())
                .email(employee.getEmail())
                .position(employee.getPosition())
                .gender(employee.getGender()).build();
    }

    public String udateEmpliyeeInfoBy(String id, EmployeeUpdateRequest employeeUpdateRequest) {

        Optional<Employee> employeeOptionalUpdate = employeeRepository.findById(id);
        if (!employeeOptionalUpdate.isPresent()) {
            //TODO
        }
        Employee employee = employeeOptionalUpdate.get();
        employee.setName(employeeUpdateRequest.getName());
        employee.setEmail(employeeUpdateRequest.getEmail());
        employee.setPosition(employeeUpdateRequest.getPosition());
        employee.setGender(employeeUpdateRequest.getGender());
        employeeRepository.save(employee);
        return "SuccessFully update";
    }

    public void deleteEmployeeBy(String id) {
        Optional<Employee> employeeOptionalDelete = employeeRepository.findById(id);
        if (!employeeOptionalDelete.isPresent()) {
            //TODO
        }
        employeeRepository.delete(employeeOptionalDelete.get());
    }

}
