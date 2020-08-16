package com.l4gunner4l.model;

import com.google.gson.annotations.SerializedName;

public abstract class Employee {
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PAY = "pay";
    public static final String KEY_TYPE = "type";
    @SerializedName(KEY_ID)
    protected long id;
    @SerializedName(KEY_NAME)
    protected String name;
    @SerializedName(KEY_PAY)
    protected double pay;
    @SerializedName(KEY_TYPE)
    protected String type;

    public Employee(long id, String name, double pay, String type) {
        this.id = id;
        this.name = name;
        this.pay = pay;
        this.type = type;
    }

    public abstract double calcSalaryOnMonth();

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPay() {
        return this.pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return type + " " + id + " " + name + " " + pay + " " + calcSalaryOnMonth();
    }
}