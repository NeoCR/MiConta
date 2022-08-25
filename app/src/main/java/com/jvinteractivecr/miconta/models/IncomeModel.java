package com.jvinteractivecr.miconta.models;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class IncomeModel {

    private int id;
    private String income;
    private int currencyId;
    private Double amount;
    private boolean applySocialCharges;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean isApplySocialCharges() {
        return applySocialCharges;
    }

    public void setApplySocialCharges(boolean applySocialCharges) {
        this.applySocialCharges = applySocialCharges;
    }
}
