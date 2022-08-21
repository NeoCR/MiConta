package com.jvinteractivecr.miconta.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class PaymentDetailModel {

    private int id;
    private int paymentId;
    private String egress;
    private BigDecimal amount;
    private Date paymentDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getEgress() {
        return egress;
    }

    public void setEgress(String egress) {
        this.egress = egress;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
