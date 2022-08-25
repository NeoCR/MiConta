package com.jvinteractivecr.miconta.models;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class ExchangeRateModel {

    private int id;
    private String exchangeRateDate;
    private Double buy;
    private Double sell;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExchangeRateDate() {
        return exchangeRateDate;
    }

    public void setExchangeRateDate(String exchangeRateDate) {
        this.exchangeRateDate = exchangeRateDate;
    }

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    public Double getSell() {
        return sell;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }
}
