package com.l4gunner4l.main;

import com.l4gunner4l.model.Employee;
import com.l4gunner4l.reader.EmployeeReader;
import com.l4gunner4l.reader.JsonEmployeeReader;
import com.l4gunner4l.utils.EmployeeComparator;
import com.l4gunner4l.utils.Utils;
import com.l4gunner4l.writer.ConsoleEmployeeWriter;
import com.l4gunner4l.writer.ConsoleWriter;
import com.l4gunner4l.writer.EmployeeWriter;
import com.l4gunner4l.writer.FileEmployeeWriter;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final String LINK_FILE = "https://raw.githubusercontent.com/nikolamikhailov/Lec4/master/src/com/l4gunner4l/in.json";
    private static final String OUT_FILE_NAME = "D:\\Work\\ABDT\\Lec4\\src\\com\\l4gunner4l\\out.txt";
    private static final String IN_FILE_NAME = "D:\\Work\\ABDT\\Lec4\\src\\com\\l4gunner4l\\in.json";
    private static final String FAIL = "FAIL";
    private static final String DONE = "DONE";

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        EmployeeReader reader = new JsonEmployeeReader();
        EmployeeWriter writer = new ConsoleEmployeeWriter();

        Utils.println("d) read from file");
        ArrayList<Employee> emps = null;
        try {
            emps = (ArrayList<Employee>) reader.readEmployees(LINK_FILE);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException(FAIL + " there isn't needed class for deserialization");
        } catch (IOException e) {
            Utils.println(FAIL + " can't read json");
        }
        Utils.println(DONE);
        writer.write(emps);

        Utils.println("a) sorting");
        emps.sort(new EmployeeComparator());
        writer.write(emps);

        Utils.println("b) 5 first names");
        ((ConsoleWriter) writer).writeEmpsNames(5, emps);

        Utils.println("c) last 3 ids");
        ((ConsoleWriter) writer).writeLastEmpsId(3, emps);

        Utils.println("d) write to file");
        writer = new FileEmployeeWriter(OUT_FILE_NAME);
        try {
            writer.write(emps);
        } catch (IOException e) {
            Utils.println(FAIL + " can't write to file");
        }
        Utils.println(DONE);
    }
}