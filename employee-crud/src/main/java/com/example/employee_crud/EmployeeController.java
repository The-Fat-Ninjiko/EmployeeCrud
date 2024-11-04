package com.example.employee_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        employee.setId(id);
        return repository.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
    }


}
