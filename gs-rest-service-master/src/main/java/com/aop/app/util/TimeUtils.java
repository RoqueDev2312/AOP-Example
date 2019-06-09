package com.aop.app.util;

import java.sql.Timestamp;

public class TimeUtils {

    public static Timestamp getTimestamp(){
        java.util.Date date = new java.util.Date();
        return  new Timestamp(date.getTime());
    }

    public static int calculateSecods(Timestamp time2,Timestamp time1){
        long milliseconds = time2.getTime() - time1.getTime();
        return  (int) milliseconds / 1000;
    }

    public static int calculateMinutes(Timestamp time2,Timestamp time1){
        return  (calculateSecods(time2,time1) % 3600) / 60;
    }

    public static int calculateHours(Timestamp time2,Timestamp time1){
        return  calculateSecods(time2,time1) / 3600;
    }

    public static Long calculateMilliseconds(Timestamp time2,Timestamp time1){
        return  time2.getTime() - time1.getTime();
    }

}