package com.l4gunner4l.utils;

import com.l4gunner4l.model.AverageEmployee;
import com.l4gunner4l.model.Employee;
import com.l4gunner4l.model.HourEmployee;

import static com.l4gunner4l.utils.Utils.SEPARATOR;

public class EmployeeConverter {

    public static Employee convertToEmployee(String line) throws ClassNotFoundException {
        String[] data = line.split(SEPARATOR);
        String className = data[0];
        long id = Long.parseLong(data[1]);
        String name = data[2];
        float pay = Float.parseFloat(data[3]);
        switch (className) {
            case HourEmployee.CLASS:
                return new HourEmployee(id, name, pay);
            case AverageEmployee.CLASS:
                return new AverageEmployee(id, name, pay);
        }
        throw new ClassNotFoundException("Not found class " + className);
    }

    public static String convertToString(Employee e) {
        return e.getType() + Utils.SEPARATOR +
                e.getId() + Utils.SEPARATOR +
                e.getName() + Utils.SEPARATOR +
                e.getPay() + Utils.SEPARATOR +
                e.calcSalaryOnMonth() +
                "\n";
    }
}
