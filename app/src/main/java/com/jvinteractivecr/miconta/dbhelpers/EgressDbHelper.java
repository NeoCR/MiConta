package com.jvinteractivecr.miconta.dbhelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jvinteractivecr.miconta.constants.Constants;
import com.jvinteractivecr.miconta.models.EgressModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeoCR
 * 24/8/2022
 */
public class EgressDbHelper extends DBHelper {

    public EgressDbHelper(Context context) {
        super(context);
    }

    public List<EgressModel> getEgress() {
        List<EgressModel> egressModels = new ArrayList<>();

        String sql = "SELECT * FROM " + Constants.TABLE_EGRESS;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                EgressModel egressModel = new EgressModel();
                egressModel.setId(cursor.getInt(0));
                egressModel.setEgress(cursor.getString(1));
                egressModel.setCurrencyId(cursor.getInt(2));
                egressModel.setAmount(cursor.getDouble(3));
                egressModel.setPayrollPeriodId(cursor.getInt(4));
                egressModels.add(egressModel);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return egressModels;
    }

    public EgressModel getEgress(int egressId) {
        EgressModel egressModel = new EgressModel();

        String sql = "SELECT * FROM " + Constants.TABLE_EGRESS;
        sql += " WHERE " + Constants.COLUMN_ID + " = ?";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(egressId)});

        if (cursor.moveToFirst()) {
            do {
                egressModel.setId(cursor.getInt(0));
                egressModel.setEgress(cursor.getString(1));
                egressModel.setCurrencyId(cursor.getInt(2));
                egressModel.setAmount(cursor.getDouble(3));
                egressModel.setPayrollPeriodId(cursor.getInt(4));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return egressModel;
    }

    private void insertEgress(EgressModel egressModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Constants.TE_EGRESS, egressModel.getEgress());
        cv.put(Constants.TE_CURRENCY_ID, egressModel.getCurrencyId());
        cv.put(Constants.TE_AMOUNT, egressModel.getAmount());
        cv.put(Constants.TE_PAYROLL_PERIOD_ID, egressModel.getPayrollPeriodId());

        db.insert(Constants.TABLE_EGRESS, null, cv);
        db.close();
    }

    private void updateEgress(EgressModel egressModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Constants.TE_EGRESS, egressModel.getEgress());
        cv.put(Constants.TE_CURRENCY_ID, egressModel.getCurrencyId());
        cv.put(Constants.TE_AMOUNT, egressModel.getAmount());
        cv.put(Constants.TE_PAYROLL_PERIOD_ID, egressModel.getPayrollPeriodId());

        db.update(Constants.TABLE_EGRESS, cv, Constants.COLUMN_ID + " = ?", new String[]{String.valueOf(egressModel.getId())});
        db.close();
    }

    private void deleteEgress(int egressId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Constants.TABLE_EGRESS, Constants.COLUMN_ID + " = ?", new String[]{String.valueOf(egressId)});
    }
}
