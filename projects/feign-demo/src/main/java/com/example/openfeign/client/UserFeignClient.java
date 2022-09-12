package com.example.openfeign.client;

import com.example.openfeign.config.ApacheHttp5FeignSslClientConfig;
import com.example.openfeign.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "userFeignClient",
    url = "${client.api.baseUrl}",
    configuration = ApacheHttp5FeignSslClientConfig.class,
    fallback = UserFeignClientFallback.class)
public interface UserFeignClient {

    @GetMapping("/employee")
    ListEmployeeResponse getEmployeeList(@RequestParam("page") Integer page);

    @GetMapping("/employee")
    ListEmployeeResponse getEmployeeListDelayed(@RequestParam("page") Integer page, @RequestParam("delay") Integer delay);

    @GetMapping("/employee/{employeeId}")
    SingleEmployeeResponse getEmployeeById(@PathVariable("employeeId") Long employeeId);

    @PostMapping("/employee")
    Employee createEmployee(@RequestBody EmployeeRequest employeeRequest);

    @PutMapping("/employee")
    Employee updateEmployee(@RequestBody EmployeeRequest employeeRequest);

    @DeleteMapping("/employee/{employeeId}")
    void deleteEmployeeById(@PathVariable("employeeId") Long employeeId);
}
