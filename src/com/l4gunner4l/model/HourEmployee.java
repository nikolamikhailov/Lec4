package com.l4gunner4l.model;

public class HourEmployee extends Employee {

    public static final double WORK_DAYS_IN_MONTH = 20.8;
    public static final int WORK_HOURS_IN_DAY = 8;
    public static final String CLASS = "HourEmployee";

    public HourEmployee(long id, String name, double pay) {
        super(id, name, pay);
    }

    @Override
    public double calcSalaryOnMonth() {
        return WORK_DAYS_IN_MONTH * WORK_HOURS_IN_DAY * pay;
    }
}