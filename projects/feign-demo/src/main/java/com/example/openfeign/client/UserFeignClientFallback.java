package com.example.openfeign.client;

import com.example.openfeign.model.ListEmployeeResponse;
import com.example.openfeign.model.Employee;
import com.example.openfeign.model.EmployeeRequest;
import com.example.openfeign.model.SingleEmployeeResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public ListEmployeeResponse getEmployeeList(Integer page) {
        return null;
    }

    @Override
    public ListEmployeeResponse getEmployeeListDelayed(Integer page, Integer delay) {
        ListEmployeeResponse listEmployeeResponse = new ListEmployeeResponse();
        listEmployeeResponse.setEmployee(List.of(Employee.builder()
            .id(1L)
            .name("George")
            .build()));
        return listEmployeeResponse;
    }

    @Override
    public SingleEmployeeResponse getEmployeeById(Long employeeId) {
        return null;
    }

    @Override
    public Employee createEmployee(EmployeeRequest employeeRequest) {
        return null;
    }

    @Override
    public Employee updateEmployee(EmployeeRequest employeeRequest) {
        return null;
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {

    }


}
