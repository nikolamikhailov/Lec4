package com.l4gunner4l.utils;

import com.l4gunner4l.model.Employee;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    public EmployeeComparator() {
    }

    // Метод для сравнения Employee и сортировки их по убыванию pay
    @Override
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