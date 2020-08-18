package com.l4gunner4l.reader;

import com.l4gunner4l.model.Employee;
import com.l4gunner4l.utils.EmployeeConverter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileEmployeeReader implements EmployeeReader {

    public FileEmployeeReader() {
    }

    @Override
    public ArrayList<Employee> readEmployees(String path) throws ClassNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        ArrayList<Employee> emps = new ArrayList();
        String line;
        while ((line = reader.readLine()) != null) {
            Employee employee = EmployeeConverter.convertToEmployee(line);
            emps.add(employee);
        }
        reader.close();
        return emps;
    }

}