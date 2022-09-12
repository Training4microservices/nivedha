package com.example.openfeign.service;

import com.example.openfeign.client.UserFeignClient;
import com.example.openfeign.model.EmployeeRequest;
import com.example.openfeign.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final UserFeignClient userFeignClient;

    public List<Employee> getEmployeeList(Integer page) {
        return userFeignClient.getEmployeeList(page).getEmployee();
    }

    public List<Employee> getEmployeeListDelayed(Integer page, Integer delay) {
        return userFeignClient.getEmployeeListDelayed(page, delay).getEmployee();
    }

    public Employee getEmployeeById(Long employeeId) {
        return userFeignClient.getEmployeeById(employeeId).getEmployee();
    }

    public Employee createEmployee(EmployeeRequest employeeRequest){
        return userFeignClient.createEmployee(employeeRequest);
    }

    public Employee updateEmployee(EmployeeRequest employeeRequest){
        return userFeignClient.updateEmployee(employeeRequest);
    }

    public void deleteEmployeeById(Long employeeId){
        userFeignClient.deleteEmployeeById(employeeId);
    }
}
