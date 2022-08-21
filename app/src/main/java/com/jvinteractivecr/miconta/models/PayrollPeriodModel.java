package com.jvinteractivecr.miconta.models;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class PayrollPeriodModel {

    private int id; // 1 = primera quincena (día 15), 2 = segunda quincena (día 28, 29, 30 o 31), 0 = ambas quincenas
    private String payrollPeriod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayrollPeriod() {
        return payrollPeriod;
    }

    public void setPayrollPeriod(String payrollPeriod) {
        this.payrollPeriod = payrollPeriod;
    }
}
