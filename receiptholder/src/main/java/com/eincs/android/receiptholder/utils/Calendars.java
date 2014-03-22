package com.eincs.android.receiptholder.utils;

import java.util.Calendar;
import java.util.Date;

public final class Calendars {
    private Calendars() {}

    public static Calendar forTime(long timemillis) {
        Date date = new Date();
        date.setTime(timemillis);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
