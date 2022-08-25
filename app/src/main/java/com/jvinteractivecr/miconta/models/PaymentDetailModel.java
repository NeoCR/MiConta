package com.jvinteractivecr.miconta.models;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class PaymentDetailModel {

    private int id;
    private int paymentId;
    private String egress;
    private Double amount;
    private String paymentDate;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
