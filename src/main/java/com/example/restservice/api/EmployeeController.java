package com.example.restservice.api;

import com.example.restservice.service.EmployeeService;
import com.example.restservice.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    //GET
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        EmployeeService service = new EmployeeService();
        return service.getAllEmployees();
    }

    //PathVariable
    @GetMapping("/employee/{id}")
    public Employee getPetById(@PathVariable int id){
        EmployeeService service = new EmployeeService();
        List<Employee> employees = service.getAllEmployees();
        //Lambda expression
        for(Employee p : employees){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
        //return Employee.stream().filter(employee -> employee.getId() == id).findFirst().get();
    }

    //POST
    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        EmployeeService service = new EmployeeService();
        service.addEmployee(employee);
        return employee;
    }

    //PUT

    //DELETE
}
