package com.l4gunner4l.model;

public class AverageEmployee extends Employee {
    public static final String TYPE = "AverageEmployee";

    public AverageEmployee(long id, String name, double pay) {
        super(id, name, pay, TYPE);
    }

    public double calcSalaryOnMonth() {
        return this.pay;
    }
}