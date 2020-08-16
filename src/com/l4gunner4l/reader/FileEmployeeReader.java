package com.l4gunner4l.reader;

import com.l4gunner4l.base.BaseEmployeeReader;
import com.l4gunner4l.model.AverageEmployee;
import com.l4gunner4l.model.Employee;
import com.l4gunner4l.model.HourEmployee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileEmployeeReader extends BaseEmployeeReader {

    public static final String SEPARATOR = " ";

    public FileEmployeeReader() {
    }

    public ArrayList<Employee> readEmployees(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(path)))) {
            ArrayList<Employee> emps = new ArrayList();
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    emps.add(parseFromLine(line));
                } catch (Exception var8) {
                    return null;
                }
            }
            return emps;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Employee parseFromLine(String line) throws Exception {
        String[] data = line.split(SEPARATOR);
        String className = data[0];
        long id = Long.parseLong(data[1]);
        String name = data[2];
        float pay = Float.parseFloat(data[3]);
        switch (className) {
            case HourEmployee.TYPE:
                return new HourEmployee(id, name, pay);
            case AverageEmployee.TYPE:
                return new AverageEmployee(id, name, pay);
            default:
                throw new Exception("Invalid parsing");
        }
    }
}