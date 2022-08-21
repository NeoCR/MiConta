package com.jvinteractivecr.miconta.models;

import java.util.Date;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class PaymentModel {

    private int id;
    private Date creationDate;
    private Date paymentDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
