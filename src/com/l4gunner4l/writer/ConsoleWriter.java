package com.l4gunner4l.writer;

import com.l4gunner4l.model.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface ConsoleWriter extends EmployeeWriter {

    @Override
    void write(List<Employee> emps) throws IOException;

    void writeLastEmpsId(int count, ArrayList<Employee> emps);

    void writeEmpsNames(int count, ArrayList<Employee> emps);
}
