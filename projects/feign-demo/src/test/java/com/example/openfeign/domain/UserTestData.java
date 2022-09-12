package com.example.openfeign.domain;

import com.example.openfeign.model.Employee;
import com.example.openfeign.model.SingleEmployeeResponse;
//import com.example.openfeign.model.User;
//import com.example.openfeign.model.SingleUserResponse;

import java.util.List;

public class UserTestData {


    public static Employee employee() {
        return Employee.builder()
            .id(1L)
            .name("George")
            //.firstName("George")
            //.lastName("Bluth")
            .build();
    }

    public static SingleEmployeeResponse employeeData() {
        SingleEmployeeResponse singleEmployeeResponse = new SingleEmployeeResponse();
        singleEmployeeResponse.setEmployee(employee());
        return singleEmployeeResponse;
    }

}
