package com.jvinteractivecr.miconta.dbhelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jvinteractivecr.miconta.constants.Constants;
import com.jvinteractivecr.miconta.models.PaymentModel;
import com.jvinteractivecr.miconta.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NeoCR
 * 24/8/2022
 */
public class PaymentDbHelper extends DBHelper {

    public PaymentDbHelper(Context context) {
        super(context);
    }

    public List<PaymentModel> getPayments(int paymentId) {
        List<PaymentModel> paymentModels = new ArrayList<>();

        String sql = "SELECT * FROM " + Constants.TABLE_PAYMENTS;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                PaymentModel paymentModel = new PaymentModel();
                paymentModel.setId(cursor.getInt(0));
                paymentModel.setCreationDate(cursor.getString(1));
                paymentModel.setPaymentDate(cursor.getString(2));
                paymentModels.add(paymentModel);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return paymentModels;
    }

    private void insertPayment(PaymentModel paymentModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Constants.TP_CREATION_DATE, Utils.getToday());
        cv.put(Constants.TP_PAYMENT_DATE, paymentModel.getPaymentDate());

        db.insert(Constants.TABLE_PAYMENTS, null, cv);
        db.close();
    }
}
