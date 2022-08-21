package com.jvinteractivecr.miconta.models;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class CurrencyModel {

    private int id; // 1 = Colones, 2 = Dolares
    private String currency; // Nombre de la moneda

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
