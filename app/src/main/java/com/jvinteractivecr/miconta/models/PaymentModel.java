package com.jvinteractivecr.miconta.models;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class PaymentModel {

    private int id;
    private String creationDate;
    private String paymentDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
