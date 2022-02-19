package com.example.restservice.service;

import com.example.restservice.exception.EmployeeExistException;
import com.example.restservice.exception.EmployeeNotFoundException;
import com.example.restservice.model.Address;
import com.example.restservice.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    static List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees(){

        Employee employee1 = new Employee(1, "Adam", "Smith",
                new Address(123, "Acadie", "Montreal", "Quebec", "Canada", "Q2W 3E1"));

        Employee employee2 = new Employee(2, "Arthur", "Big",
                new Address(456, "Mont Royal", "Outremont", "Quebec", "Canada", "Y6U 3F7"));

        Employee employee3 = new Employee(3, "Zoe", "Boily",
                new Address(678, "Rene Levesque", "Laval", "Quebec", "Canada", "U8U 6G7"));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        return employees;
    }

    public Employee getById(int id){
        Employee employee = findById(id);
        if (employee != null){
            return employee;
        }
        throw new EmployeeNotFoundException("Employee with " + id + "not found");
    }

    public Employee getByAddressPostalCode(String addressPostalCode){
        Employee fetchedEmployee = this.findByAddressPostalCode(addressPostalCode);
        if (fetchedEmployee != null){
            return fetchedEmployee;
        }
        throw new EmployeeNotFoundException("Employee with " + addressPostalCode + "not found");
    }

    public void addEmployee(Employee employee){
        Employee fetchedEmployee = this.findByAddressPostalCode(employee.getAddress().getPostalCode());
        if (fetchedEmployee == null){
            employees.add(employee);
        }
        throw new EmployeeExistException("Employee who lives in this postal code" + employee.getAddress().getPostalCode() + " already exists");
    }

    public void updateEmployee(int id, Employee employee){
        Employee fetchedEmployee = this.findById(id);
        if (fetchedEmployee != null){
            fetchedEmployee = employee;
        }
    }

    public void deleteEmployee(int id){
        Employee fetchedEmployee = this.findById(id);
        if (fetchedEmployee != null){
        }
    }

    private Employee findById(int id){
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().get();
    }

    private Employee findByAddressPostalCode(String addressPostalCode){
        return employees.stream().filter(employee -> employee.getAddress().getPostalCode().equals(addressPostalCode)).findFirst().get();
    }
}
