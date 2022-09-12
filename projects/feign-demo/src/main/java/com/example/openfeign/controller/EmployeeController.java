package com.example.openfeign.controller;

import com.example.openfeign.model.Employee;
import com.example.openfeign.model.EmployeeRequest;
import com.example.openfeign.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    List<Employee> getEmployeeListDelayed(@RequestParam("page") Integer page, @RequestParam(name = "delay", defaultValue = "0") Integer delay){
        return employeeService.getEmployeeListDelayed(page, delay);
    }

    @GetMapping("/{employeeId}")
    Employee getEmployeeById(@PathVariable("employeeId") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    Employee createUser(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.createEmployee(employeeRequest);
    }

    @PutMapping
    Employee updateEmployee(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.updateEmployee(employeeRequest);
    }

    @DeleteMapping("/{employeeId}")
    void deleteEmployeeById(@PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }
}
/*

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    private List getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    */
/*@GetMapping("/employees/{id}")
    private Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }
*//*


    @GetMapping("/employees/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable("id") int id) {
        Optional<Employee> employee = Optional.ofNullable(employeeService.getEmployeeById(id));
        if(employeeService.getEmployeeById(id).getSalary() < employeeService.averageSalary())
            throw new InsufficientSalaryException("Employee with below average salary:"+id);
        else
            return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }
    @PostMapping("/employees")
    private ResponseEntity createEmployee(@Valid @RequestBody Employee employee) {
        try{
            employeeService.saveOrUpdate(employee);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("New employee created with id: "+employee.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{id}")
    private ResponseEntity deleteById(@PathVariable("id") int id) {
        try{
            employeeService.delete(id);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Employee deleted with id: "+id, HttpStatus.OK);
    }

    @PutMapping("/employees")
    private ResponseEntity updateEmployee(@RequestBody Employee employee) {
        try{
            employeeService.saveOrUpdate(employee);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(" employee updated with id: "+employee.getId(), HttpStatus.OK);
    }

    @PatchMapping("/employees/{id}")
    public ResponseEntity<?> updateEmployeeByPatch(@RequestParam("name") String name, @PathVariable("id") Integer id){
        Employee employee = employeeService.updateEmployee(name,id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }


}*/
