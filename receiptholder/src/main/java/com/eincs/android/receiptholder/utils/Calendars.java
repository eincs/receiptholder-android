package com.eincs.android.receiptholder.utils;

import java.util.Calendar;
import java.util.Date;

public final class Calendars {
    private Calendars() {}

    /**
     * 밀리세컨드를 넘기면 해당 시각을 가리키는 Calendar 인스턴스를 만들어 리턴한다.
     * long으로 표현되는 밀리세컨드에서 실제 연도, 월, 일을 알아내기 위핸 용도로 Calendar객체를 만드는 경우가 있다.
     * 이 경우를 쉽게 하기 위한 유틸리디 메소드
     */
    public static Calendar forTime(long timemillis) {
        Date date = new Date();
        date.setTime(timemillis);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
}
