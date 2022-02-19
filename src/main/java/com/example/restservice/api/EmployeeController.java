package com.example.restservice.api;

import com.example.restservice.exception.EmployeeExistException;
import com.example.restservice.exception.EmployeeNotFoundException;
import com.example.restservice.service.EmployeeService;
import com.example.restservice.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmployeeController {

    EmployeeService employeeService = new EmployeeService();

    //GET
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //PathVariable
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        try {
            return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
        }
        catch (EmployeeNotFoundException employeeNotFoundException){
            return new ResponseEntity(employeeNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //ResponseEntity => to send the result/exception message with httpStatus
    @GetMapping("/employee/Address/{postalCode}")
    public ResponseEntity<Employee> getPetByFirstName(@PathVariable String postalCode){
        try{
            return new ResponseEntity<>(employeeService.getByAddressPostalCode(postalCode), HttpStatus.OK);
        }
        catch (EmployeeNotFoundException employeeNotFoundException) {
            return new ResponseEntity(employeeNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //POST
    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        try{
            employeeService.addEmployee(employee);
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        }
        catch (EmployeeExistException exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }

    //PUT
    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> modifyEmployee(@PathVariable int id, @RequestBody Employee employee){
        try{
            employeeService.updateEmployee(id, employee);
            return new ResponseEntity<>(employee, HttpStatus.NO_CONTENT);
        }
        catch (EmployeeNotFoundException exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping("/pet/{id}")
    public ResponseEntity deletePet(@PathVariable int id){
        try{
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (EmployeeNotFoundException exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
