package com.l4gunner4l;

import com.l4gunner4l.model.Employee;
import com.l4gunner4l.reader.EmployeeReader;
import com.l4gunner4l.reader.JsonEmployeeReader;
import com.l4gunner4l.writer.ConsoleEmployeeWriter;
import com.l4gunner4l.writer.EmployeeWriter;
import com.l4gunner4l.writer.FileEmployeeWriter;

import java.util.ArrayList;

public class Main {
    private static final String LINK_FILE = "https://raw.githubusercontent.com/nikolamikhailov/Lec4/master/in.txt";
    private static final String OUT_FILE_NAME = "D:\\Work\\ABDT\\Lec4\\src\\com\\l4gunner4l\\out.txt";
    private static final String IN_FILE_NAME = "D:\\Work\\ABDT\\Lec4\\src\\com\\l4gunner4l\\in.json";
    private static final String FAIL = "FAIL";
    private static final String DONE = "DONE";

    public static void main(String[] args) {
        EmployeeReader reader = new JsonEmployeeReader();
        EmployeeWriter writer = new ConsoleEmployeeWriter();

        Utils.println("d) read from file");
        ArrayList<Employee> emps = reader.readEmployees(LINK_FILE);
        if (emps == null) {
            Utils.println(FAIL);
            return;
        }
        Utils.println(DONE);
        writer.write(null, emps);

        Utils.println("a) sorting");
        emps.sort(new EmployeeComparator());
        writer.write(null, emps);

        Utils.println("b) 5 first names");
        ((ConsoleEmployeeWriter) writer).printEmpsNames(5, emps);

        Utils.println("c) last 3 ids");
        ((ConsoleEmployeeWriter) writer).printLastEmpsId(3, emps);

        Utils.println("d) write to file");
        writer = new FileEmployeeWriter();
        boolean isSuccess = writer.write(OUT_FILE_NAME, emps);
        if (isSuccess) {
            Utils.println(DONE);
        } else {
            Utils.println(FAIL);
        }
    }
}