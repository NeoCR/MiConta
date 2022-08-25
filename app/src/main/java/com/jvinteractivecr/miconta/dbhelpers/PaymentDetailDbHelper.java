package com.jvinteractivecr.miconta.dbhelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jvinteractivecr.miconta.constants.Constants;
import com.jvinteractivecr.miconta.models.PaymentDetailModel;
import com.jvinteractivecr.miconta.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeoCR
 * 24/8/2022
 */
public class PaymentDetailDbHelper extends DBHelper {

    public PaymentDetailDbHelper(Context context) {
        super(context);
    }

    public List<PaymentDetailModel> getPaymentDetails(int paymentId) {
        List<PaymentDetailModel> paymentDetailModels = new ArrayList<>();

        String sql = "SELECT * FROM " + Constants.TABLE_PAYMENT_DETAILS;
        sql += " WHERE " + Constants.TPD_PAYMENT_ID + " = ?";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(paymentId)});

        if (cursor.moveToFirst()) {
            do {
                PaymentDetailModel paymentDetailModel = new PaymentDetailModel();
                paymentDetailModel.setId(cursor.getInt(0));
                paymentDetailModel.setPaymentId(cursor.getInt(1));
                paymentDetailModel.setEgress(cursor.getString(2));
                paymentDetailModel.setAmount(cursor.getDouble(3));
                paymentDetailModel.setPaymentDate(cursor.getString(4));
                paymentDetailModels.add(paymentDetailModel);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return paymentDetailModels;
    }

    private void insertPaymentDetail(PaymentDetailModel paymentDetailModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Constants.TPD_PAYMENT_ID, paymentDetailModel.getPaymentId());
        cv.put(Constants.TPD_EGRESS, paymentDetailModel.getEgress());
        cv.put(Constants.TPD_AMOUNT, paymentDetailModel.getAmount());
        cv.putNull(Constants.TPD_PAY_DATE);

        db.insert(Constants.TABLE_PAYMENT_DETAILS, null, cv);
        db.close();
    }

    private void updatePaymentDetailPayDate(int paymentDetailId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Constants.TPD_PAY_DATE, Utils.getToday());

        db.update(Constants.TABLE_PAYMENT_DETAILS, cv, Constants.COLUMN_ID + " = ?", new String[]{String.valueOf(paymentDetailId)});
        db.close();
    }
}
