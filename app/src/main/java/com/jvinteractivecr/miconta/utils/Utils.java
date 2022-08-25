package com.jvinteractivecr.miconta.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by NeoCR
 * 24/8/2022
 */
public class Utils {

    public static String getToday()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return formatter.format(date);
    }

}
