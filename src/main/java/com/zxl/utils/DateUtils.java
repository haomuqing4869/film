package com.zxl.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getDate(Date date){
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH");
        String format = dateFormat.format(date);
        return format;
    }
    public static Date getStringtodate(String string) throws ParseException {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date parse = dateFormat.parse(string);
        return parse;
    }
}
