package com.l4gunner4l.model;

public class HourEmployee extends Employee {
    public static final String TYPE = "HourEmployee";

    public HourEmployee(long id, String name, double pay) {
        super(id, name, pay, TYPE);
    }

    public double calcSalaryOnMonth() {
        return 20.8 * 8 * pay;
    }
}