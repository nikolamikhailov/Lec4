package com.l4gunner4l.writer;

import com.l4gunner4l.model.Employee;
import com.l4gunner4l.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ConsoleEmployeeWriter implements ConsoleWriter {
    public ConsoleEmployeeWriter() {
    }

    @Override
    public void write(List<Employee> emps) {
        for (Employee e : emps) {
            Utils.println(e.toString());
        }
        Utils.println("");
    }

    @Override
    public void writeLastEmpsId(int count, ArrayList<Employee> emps) {
        for (int i = emps.size() - count; i < emps.size(); i++) {
            Utils.println(String.valueOf(emps.get(i).getId()));
        }
        Utils.println("");
    }

    @Override
    public void writeEmpsNames(int count, ArrayList<Employee> emps) {
        for (int i = 0; i < count; i++) {
            Utils.println(emps.get(i).getName());
        }
        Utils.println("");
    }
}
