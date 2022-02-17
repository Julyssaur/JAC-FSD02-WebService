package com.example.restservice.service;

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

    public void addEmployee(Employee employee){
        employees.add(employee);
    }
}
