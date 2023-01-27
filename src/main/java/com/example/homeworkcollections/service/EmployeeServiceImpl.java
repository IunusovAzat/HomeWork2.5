package com.example.homeworkcollections.service;

import com.example.homeworkcollections.exceprion.EmployeeAlreadyAddedException;
import com.example.homeworkcollections.exceprion.EmployeeNotFoundException;
import com.example.homeworkcollections.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)){
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже записан");
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)){
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Данного сотрудника нет в списке");
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException("Массив сотрудников переполнен");
    }

    @Override
    public List<Employee> findAll() {
        return Collections.unmodifiableList(employeeList);
    }
}
