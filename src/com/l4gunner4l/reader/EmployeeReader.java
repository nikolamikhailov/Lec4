package com.l4gunner4l.reader;

import com.l4gunner4l.model.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeReader {
    List<Employee> readEmployees(String path) throws ClassNotFoundException, IOException;
}