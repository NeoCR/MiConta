package com.jvinteractivecr.miconta.dbhelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jvinteractivecr.miconta.constants.Constants;
import com.jvinteractivecr.miconta.models.IncomeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeoCR
 * 24/8/2022
 */
public class IncomeDbHelper extends DBHelper {

    public IncomeDbHelper(Context context) {
        super(context);
    }

    public List<IncomeModel> getIncome() {
        List<IncomeModel> incomeModels = new ArrayList<>();

        String sql = "SELECT * FROM " + Constants.TABLE_INCOME;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                IncomeModel incomeModel = new IncomeModel();
                incomeModel.setId(cursor.getInt(0));
                incomeModel.setIncome(cursor.getString(1));
                incomeModel.setCurrencyId(cursor.getInt(2));
                incomeModel.setAmount(cursor.getDouble(3));
                incomeModel.setApplySocialCharges(cursor.getInt(4) == 1);
                incomeModels.add(incomeModel);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return incomeModels;
    }

    public IncomeModel getIncome(int incomeId) {
        IncomeModel incomeModel = new IncomeModel();

        String sql = "SELECT * FROM " + Constants.TABLE_INCOME;
        sql += " WHERE " + Constants.COLUMN_ID + " = ?";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(incomeId)});

        if (cursor.moveToFirst()) {
            do {
                incomeModel.setId(cursor.getInt(0));
                incomeModel.setIncome(cursor.getString(1));
                incomeModel.setCurrencyId(cursor.getInt(2));
                incomeModel.setAmount(cursor.getDouble(3));
                incomeModel.setApplySocialCharges(cursor.getInt(4) == 1);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return incomeModel;
    }

    private void insertIncome(IncomeModel incomeModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Constants.TI_INCOME, incomeModel.getIncome());
        cv.put(Constants.TI_CURRENCY_ID, incomeModel.getCurrencyId());
        cv.put(Constants.TI_AMOUNT, incomeModel.getAmount());
        cv.put(Constants.TI_APPLY_SOCIAL_CHARGES, incomeModel.isApplySocialCharges());

        db.insert(Constants.TABLE_INCOME, null, cv);
        db.close();
    }

    private void updateIncome(IncomeModel incomeModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Constants.TI_INCOME, incomeModel.getIncome());
        cv.put(Constants.TI_CURRENCY_ID, incomeModel.getCurrencyId());
        cv.put(Constants.TI_AMOUNT, incomeModel.getAmount());
        cv.put(Constants.TI_APPLY_SOCIAL_CHARGES, incomeModel.isApplySocialCharges());

        db.update(Constants.TABLE_INCOME, cv, Constants.COLUMN_ID + " = ?", new String[]{String.valueOf(incomeModel.getId())});
        db.close();
    }

    private void deleteIncome(int incomeId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Constants.TABLE_INCOME, Constants.COLUMN_ID + " = ?", new String[]{String.valueOf(incomeId)});
    }
}
