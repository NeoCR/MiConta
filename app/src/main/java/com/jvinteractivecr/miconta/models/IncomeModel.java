package com.jvinteractivecr.miconta.models;

import java.math.BigDecimal;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class IncomeModel {

    private int id;
    private String income;
    private int currencyId;
    private BigDecimal amount;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isApplySocialCharges() {
        return applySocialCharges;
    }

    public void setApplySocialCharges(boolean applySocialCharges) {
        this.applySocialCharges = applySocialCharges;
    }
}
