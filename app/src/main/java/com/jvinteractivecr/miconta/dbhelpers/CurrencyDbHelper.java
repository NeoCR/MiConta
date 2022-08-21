package com.jvinteractivecr.miconta.dbhelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jvinteractivecr.miconta.constants.Constants;
import com.jvinteractivecr.miconta.models.CurrencyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class CurrencyDbHelper extends DBHelper {

    public CurrencyDbHelper(Context context) {
        super(context);
    }

    public List<CurrencyModel> getCurrencies()
    {
        List<CurrencyModel> currencies = new ArrayList<>();

        String sql =  "SELECT * FROM " + Constants.TABLE_CURRENCIES;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {
                CurrencyModel currencyModel = new CurrencyModel();
                currencyModel.setId(cursor.getInt(0));
                currencyModel.setCurrency(cursor.getString(1));
                currencies.add(currencyModel);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return currencies;
    }
}
