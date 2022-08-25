package com.jvinteractivecr.miconta.dbhelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jvinteractivecr.miconta.constants.Constants;
import com.jvinteractivecr.miconta.models.ExchangeRateModel;
import com.jvinteractivecr.miconta.utils.Utils;

/**
 * Created by NeoCR
 * 24/8/2022
 */
public class ExchangeRateDbHelper extends DBHelper {

    public ExchangeRateDbHelper(Context context) {
        super(context);
    }

    public ExchangeRateModel getExchangeRate()
    {
        ExchangeRateModel exchangeRateModel = new ExchangeRateModel();

        String sql =  "SELECT * FROM " + Constants.TABLE_EXCHANGE_RATE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            exchangeRateModel.setExchangeRateDate(cursor.getString(0));
            exchangeRateModel.setBuy(cursor.getDouble(1));
            exchangeRateModel.setSell(cursor.getDouble(2));
        }

        cursor.close();
        db.close();

        return exchangeRateModel;
    }

    private void updateExchangeRate(ExchangeRateModel exchangeRateModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Constants.TER_COL_DATE, Utils.getToday());
        cv.put(Constants.TER_COL_BUY, exchangeRateModel.getBuy());
        cv.put(Constants.TER_COL_SELL, exchangeRateModel.getSell());
        db.update(Constants.TABLE_EXCHANGE_RATE, cv, Constants.COLUMN_ID + " = 1", null);
    }
}
