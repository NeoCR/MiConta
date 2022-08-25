package com.jvinteractivecr.miconta.constants;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class Constants {

    public static final String DB_NAME = "MiConta.db";
    public static final int DB_VERSION = 1;

    // Es la misma columna para las tablas
    public static final String COLUMN_ID = "ID";

    // Tabla y campos de currencies
    public static final String TABLE_CURRENCIES = "CURRENCIES";
    public static final String TC_COL_CURRENCY = "CURRENCY";

    // Tabla y campos de los egresos
    public static final String TABLE_EGRESS = "EGRESS";
    public static final String TE_EGRESS = "EGRESS";
    public static final String TE_CURRENCY_ID = "CURRENCY_ID";
    public static final String TE_AMOUNT = "AMOUNT";
    public static final String TE_PAYROLL_PERIOD_ID = "PERIOD_ID";

    // Tabla y campos del exchange rate
    public static final String TABLE_EXCHANGE_RATE = "EXCHANGE_RATE";
    public static final String TER_COL_DATE = "LAST_UPDATE";
    public static final String TER_COL_BUY = "BUY";
    public static final String TER_COL_SELL = "SELL";

    // Tabla y campos de los ingresos
    public static final String TABLE_INCOME = "INCOME";
    public static final String TI_INCOME = "INCOME";
    public static final String TI_CURRENCY_ID = "CURRENCY_ID";
    public static final String TI_AMOUNT = "AMOUNT";
    public static final String TI_APPLY_SOCIAL_CHARGES = "SOCIAL_CHARGES";

    // Tabla y campos de los detalles de los pagos
    public static final String TABLE_PAYMENT_DETAILS = "PAYMENT_DETAILS";
    public static final String TPD_PAYMENT_ID = "PAYMENT_ID";
    public static final String TPD_EGRESS = "EGRESS";
    public static final String TPD_AMOUNT = "AMOUNT";
    public static final String TPD_PAY_DATE = "PAY_DATE";

    // Tabla y campos de los pagos
    public static final String TABLE_PAYMENTS = "PAYMENTS";
    public static final String TP_CREATION_DATE = "CREATION_DATE";
    public static final String TP_PAYMENT_DATE = "PAYMENT_DATE";

    // Tabla y campos de los periodos de payroll
    public static final String TABLE_PAYROLL_PERIODS = "PAYROLL_PERIODS";
    public static final String TPP_PAYROLL_PERIOD = "PAYROLL_PERIOD";
}
