package com.l4gunner4l.writer;

import com.l4gunner4l.model.Employee;
import com.l4gunner4l.utils.EmployeeConverter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileEmployeeWriter implements EmployeeWriter {
    private String path;

    public FileEmployeeWriter(String filePath) {
        this.path = filePath;
    }

    @Override
    public void write(List<Employee> emps) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));
        for (Employee e : emps) {
            writer.write(EmployeeConverter.convertToString(e));
        }
        writer.close();
    }
}
