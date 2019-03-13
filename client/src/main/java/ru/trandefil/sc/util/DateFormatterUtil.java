package ru.trandefil.sc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatterUtil {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");

    public static Date parse(final String dateString) throws ParseException {
        return simpleDateFormat.parse(dateString);
    }

    public static String format(final Date date) {
        return simpleDateFormat.format(date);
    }

}
