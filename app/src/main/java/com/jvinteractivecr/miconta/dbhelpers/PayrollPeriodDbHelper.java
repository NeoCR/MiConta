package com.jvinteractivecr.miconta.dbhelpers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jvinteractivecr.miconta.constants.Constants;
import com.jvinteractivecr.miconta.models.PayrollPeriodModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeoCR
 * 21/8/2022
 */
public class PayrollPeriodDbHelper extends DBHelper {

    public PayrollPeriodDbHelper(Context context) {
        super(context);
    }

    public List<PayrollPeriodModel> getPayrollPeriods()
    {
        List<PayrollPeriodModel> payrollPeriodModels = new ArrayList<>();

        String sql =  "SELECT * FROM " + Constants.TABLE_PAYROLL_PERIODS;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()){
            do {
                PayrollPeriodModel payrollPeriodModel = new PayrollPeriodModel();
                payrollPeriodModel.setId(cursor.getInt(0));
                payrollPeriodModel.setPayrollPeriod(cursor.getString(1));
                payrollPeriodModels.add(payrollPeriodModel);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return payrollPeriodModels;
    }
}
