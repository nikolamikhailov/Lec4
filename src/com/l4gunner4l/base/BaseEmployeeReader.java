package com.l4gunner4l.base;

import com.l4gunner4l.model.Employee;
import com.l4gunner4l.reader.EmployeeReader;

import java.util.ArrayList;

public abstract class BaseEmployeeReader implements EmployeeReader {

    public BaseEmployeeReader() {
    }

    public abstract ArrayList<Employee> readEmployees(String path);
}