package com.l4gunner4l;

import com.l4gunner4l.model.Employee;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    public EmployeeComparator() {
    }

    public int compare(Employee o, Employee other) {
        if (o.calcSalaryOnMonth() > other.calcSalaryOnMonth()) {
            return -1;
        }
        if (o.calcSalaryOnMonth() < other.calcSalaryOnMonth()) {
            return 1;
        } else {
            return o.getName().compareTo(other.getName());
        }
    }
}