package com.l4gunner4l.reader;

import com.l4gunner4l.model.Employee;

import java.util.ArrayList;

public interface EmployeeReader {
    ArrayList<Employee> readEmployees(String path);
}