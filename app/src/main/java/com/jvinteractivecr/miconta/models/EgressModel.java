package com.jvinteractivecr.miconta.models;

import java.math.BigDecimal;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class EgressModel {
    private int id;
    private String egress; // Nombre o detalle del egreso
    private int currencyId;
    private BigDecimal amount;
    private int payrollPeriodId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEgress() {
        return egress;
    }

    public void setEgress(String egress) {
        this.egress = egress;
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

    public int getPayrollPeriodId() {
        return payrollPeriodId;
    }

    public void setPayrollPeriodId(int payrollPeriodId) {
        this.payrollPeriodId = payrollPeriodId;
    }
}
