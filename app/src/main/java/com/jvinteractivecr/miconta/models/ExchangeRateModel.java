package com.jvinteractivecr.miconta.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class ExchangeRateModel {

    private Date exchangeRateDate;
    private BigDecimal buy;
    private BigDecimal sell;

    public Date getExchangeRateDate() {
        return exchangeRateDate;
    }

    public void setExchangeRateDate(Date exchangeRateDate) {
        this.exchangeRateDate = exchangeRateDate;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }
}
