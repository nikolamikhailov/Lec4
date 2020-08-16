package com.l4gunner4l.writer;

import com.l4gunner4l.model.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileEmployeeWriter implements EmployeeWriter {
    public FileEmployeeWriter() {
    }

    public boolean write(String path, ArrayList<Employee> emps) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));

            boolean var9;
            try {
                Iterator var4 = emps.iterator();

                while (true) {
                    if (!var4.hasNext()) {
                        var9 = true;
                        break;
                    }

                    Employee emp = (Employee) var4.next();
                    writer.write(emp.toString() + "\n");
                }
            } catch (Throwable var7) {
                try {
                    writer.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            writer.close();
            return var9;
        } catch (IOException var8) {
            var8.printStackTrace();
            return false;
        }
    }
}
