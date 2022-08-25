package com.jvinteractivecr.miconta.dbhelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jvinteractivecr.miconta.constants.Constants;
import com.jvinteractivecr.miconta.utils.Utils;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        currencies(db);
        egress(db);
        exchangeRate(db);
        income(db);
        paymentDetail(db);
        payment(db);
        payrollPeriod(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void currencies(SQLiteDatabase db) {
        createCurrencyTable(db); // Se crea la tabla de currencies
        addInitCurrencies(db); // Valores iniciales de los currencies
    }

    private void createCurrencyTable(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + Constants.TABLE_CURRENCIES + " (";
        sql += Constants.COLUMN_ID + " INTEGER PRIMARY KEY, ";
        sql += Constants.TC_COL_CURRENCY + " TEXT ";
        sql += ")";

        db.execSQL(sql);
    }

    private void addInitCurrencies(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();

        cv.put(Constants.COLUMN_ID, 1);
        cv.put(Constants.TC_COL_CURRENCY, "Colones");
        db.insert(Constants.TABLE_CURRENCIES, null, cv);

        cv.put(Constants.COLUMN_ID, 2);
        cv.put(Constants.TC_COL_CURRENCY, "Dólares");
        db.insert(Constants.TABLE_CURRENCIES, null, cv);
    }

    private void egress(SQLiteDatabase db)
    {
        createEgressTable(db);
    }

    private void createEgressTable(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE " + Constants.TABLE_EGRESS + " (";
        sql += Constants.COLUMN_ID + " INTEGER PRIMARY KEY, ";
        sql += Constants.TE_EGRESS + " TEXT, ";
        sql += Constants.TE_CURRENCY_ID + " INTEGER, ";
        sql += Constants.TE_AMOUNT + " REAL, ";
        sql += Constants.TE_PAYROLL_PERIOD_ID + " INTEGER ";
        sql += ")";

        db.execSQL(sql);
    }

    private void exchangeRate(SQLiteDatabase db) {
        createExchangeRateTable(db); // Se crea la tabla de exchange rate
        addInitExchangeRate(db); // Valores iniciales del exchange rate
    }

    private void createExchangeRateTable(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE " + Constants.TABLE_EXCHANGE_RATE + " (";
        sql += Constants.COLUMN_ID + " INTEGER PRIMARY KEY, ";
        sql += Constants.TER_COL_DATE + " TEXT, ";
        sql += Constants.TER_COL_BUY + " REAL, ";
        sql += Constants.TER_COL_SELL + " REAL ";
        sql += ")";

        db.execSQL(sql);
    }

    private void addInitExchangeRate(SQLiteDatabase db)
    {
        ContentValues cv = new ContentValues();

        cv.put(Constants.COLUMN_ID, 1);
        cv.put(Constants.TER_COL_DATE, Utils.getToday());
        cv.put(Constants.TER_COL_BUY, 0);
        cv.put(Constants.TER_COL_SELL, 0);
        db.insert(Constants.TABLE_CURRENCIES, null, cv);
    }

    private void income(SQLiteDatabase db)
    {
        createIncomeTable(db);
    }

    private void createIncomeTable(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE " + Constants.TABLE_INCOME + " (";
        sql += Constants.COLUMN_ID + " INTEGER PRIMARY KEY, ";
        sql += Constants.TI_INCOME + " TEXT, ";
        sql += Constants.TI_CURRENCY_ID + " INTEGER, ";
        sql += Constants.TI_AMOUNT + " REAL, ";
        sql += Constants.TI_APPLY_SOCIAL_CHARGES + " INTEGER ";
        sql += ")";

        db.execSQL(sql);
    }

    private void paymentDetail(SQLiteDatabase db)
    {
        createPaymentDetailTable(db);
    }

    private void createPaymentDetailTable(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE " + Constants.TABLE_PAYMENT_DETAILS + " (";
        sql += Constants.COLUMN_ID + " INTEGER PRIMARY KEY, ";
        sql += Constants.TPD_PAYMENT_ID + " INTEGER, ";
        sql += Constants.TPD_EGRESS + " TEXT, ";
        sql += Constants.TPD_AMOUNT + " REAL, ";
        sql += Constants.TPD_PAY_DATE + " TEXT ";
        sql += ")";

        db.execSQL(sql);
    }

    private void payment(SQLiteDatabase db)
    {
        createPaymentTable(db);
    }

    private void createPaymentTable(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE " + Constants.TABLE_PAYMENTS + " (";
        sql += Constants.COLUMN_ID + " INTEGER PRIMARY KEY, ";
        sql += Constants.TP_CREATION_DATE + " TEXT, ";
        sql += Constants.TPD_PAY_DATE + " TEXT ";
        sql += ")";

        db.execSQL(sql);
    }

    private void payrollPeriod(SQLiteDatabase db)
    {
        createPayrollPeriodTable(db);
        addInitPayrollPeriod(db);
    }

    private void createPayrollPeriodTable(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE " + Constants.TABLE_PAYROLL_PERIODS + " (";
        sql += Constants.COLUMN_ID + " INTEGER PRIMARY KEY, ";
        sql += Constants.TPP_PAYROLL_PERIOD + " TEXT ";
        sql += ")";

        db.execSQL(sql);
    }

    private void addInitPayrollPeriod(SQLiteDatabase db)
    {
        ContentValues cv = new ContentValues();

        cv.put(Constants.COLUMN_ID, 0);
        cv.put(Constants.TPP_PAYROLL_PERIOD, "Ambas Quincenas");
        db.insert(Constants.TABLE_PAYROLL_PERIODS, null, cv);

        cv.put(Constants.COLUMN_ID, 1);
        cv.put(Constants.TPP_PAYROLL_PERIOD, "Primera Quincena (día 15)");
        db.insert(Constants.TABLE_PAYROLL_PERIODS, null, cv);

        cv.put(Constants.COLUMN_ID, 2);
        cv.put(Constants.TPP_PAYROLL_PERIOD, "Segunda Quincena (día 28, 29, 30 o 31)");
        db.insert(Constants.TABLE_PAYROLL_PERIODS, null, cv);
    }
}
