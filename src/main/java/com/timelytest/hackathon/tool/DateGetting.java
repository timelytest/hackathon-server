package com.timelytest.hackathon.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateGetting {
    private DateGetting() {
        throw new IllegalStateException("DateGetting class");
    }

    public static String getDate(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
