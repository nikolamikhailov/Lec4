package com.l4gunner4l.writer;

import com.l4gunner4l.Utils;
import com.l4gunner4l.model.Employee;

import java.util.ArrayList;
import java.util.Iterator;

public class ConsoleEmployeeWriter implements EmployeeWriter {
    public ConsoleEmployeeWriter() {
    }

    public boolean write(String path, ArrayList<Employee> emps) {
        Iterator var3 = emps.iterator();

        while (var3.hasNext()) {
            Employee emp = (Employee) var3.next();
            String var10000 = emp.toString();
            Utils.println(var10000 + " " + emp.calcSalaryOnMonth());
        }

        Utils.println("");
        return true;
    }

    public void printLastEmpsId(int count, ArrayList<Employee> emps) {
        for (int i = emps.size() - count; i < emps.size(); ++i) {
            Utils.println(String.valueOf(((Employee) emps.get(i)).getId()));
        }

        Utils.println("");
    }

    public void printEmpsNames(int count, ArrayList<Employee> emps) {
        for (int i = 0; i < count; ++i) {
            Utils.println(((Employee) emps.get(i)).getName());
        }

        Utils.println("");
    }
}
