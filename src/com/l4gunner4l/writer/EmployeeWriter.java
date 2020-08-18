package com.l4gunner4l.writer;

import com.l4gunner4l.model.Employee;

import java.io.IOException;
import java.util.List;

public interface EmployeeWriter {
    void write(List<Employee> emps) throws IOException;
}