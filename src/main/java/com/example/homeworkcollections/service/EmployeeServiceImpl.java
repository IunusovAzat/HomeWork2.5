package com.example.homeworkcollections.service;

import com.example.homeworkcollections.exceprion.EmployeeAlreadyAddedException;
import com.example.homeworkcollections.exceprion.EmployeeNotFoundException;
import com.example.homeworkcollections.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже записан");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())){
            return employees.remove(employee.getFullName());

        }
        throw new EmployeeNotFoundException("Данного сотрудника нет в списке");
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())){
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Массив сотрудников переполнен");
    }

    @Override
    public Collections findAll() {
        return (Collections) Collections.unmodifiableCollection(employees.values());
    }
}
