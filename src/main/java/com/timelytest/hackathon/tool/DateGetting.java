package com.timelytest.hackathon.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateGetting {
    public String getDate(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH");
        return simpleDateFormat.format(new Date());
    }
}
