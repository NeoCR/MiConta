package com.jvinteractivecr.miconta.dbhelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jvinteractivecr.miconta.constants.Constants;
import com.jvinteractivecr.miconta.models.CurrencyModel;

import java.util.ArrayList;
import java.util.List;

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
        sql += Constants.COLUMN_CURRENCY + " TEXT ";
        sql += ")";

        db.execSQL(sql);
    }

    public void addInitCurrencies(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();

        cv.put(Constants.COLUMN_ID, 1);
        cv.put(Constants.COLUMN_CURRENCY, "Colones");
        db.insert(Constants.TABLE_CURRENCIES, null, cv);

        cv.put(Constants.COLUMN_ID, 2);
        cv.put(Constants.COLUMN_CURRENCY, "Dólares");
        db.insert(Constants.TABLE_CURRENCIES, null, cv);
    }
}
