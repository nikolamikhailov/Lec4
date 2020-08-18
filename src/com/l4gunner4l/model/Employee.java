package com.l4gunner4l.model;

public abstract class Employee {

    protected long id;
    protected String name;
    protected double pay;

    public Employee(long id, String name, double pay) {
        this.id = id;
        this.name = name;
        this.pay = pay;
    }

    public abstract double calcSalaryOnMonth();

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPay() {
        return this.pay;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getType() + " " + id + " " + name + " " + pay + " " + calcSalaryOnMonth();
    }
}