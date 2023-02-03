package com.example.homeworkcollections.service;

import com.example.homeworkcollections.model.Employee;

import java.util.Collections;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);

    Collections findAll();
}
