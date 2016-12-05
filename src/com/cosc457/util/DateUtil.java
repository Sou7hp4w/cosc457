package com.cosc457.util;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by donnie on 11/30/16.
 */
public class DateUtil {

    public static ArrayList<String> getWeekdays(){
        ArrayList<String> days = new ArrayList<String>();
        days.add("Sunday");
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        return days;
    }

    public static ArrayList<String> getTimes(){
        return createTimeTable();
    }


    private static ArrayList<String> createTimeTable(){
        int[] hours = {12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        String[] mins = {"00", "15", "30", "45"}; //because 00
        String[] zz = {"am", "pm"};
        ArrayList<String> times = new ArrayList<String>();
        for(int k = 0; k < zz.length; k++){
            for(int i = 0; i < hours.length; i++){
                for(int j = 0; j < mins.length; j++){
                    times.add(hours[i] + ":"+ mins[j] + " " + zz[k]);
                }
            }
        }
        return times;
    }

    public static Time getTimeFromString(String t){
        DateFormat format = new SimpleDateFormat("hh:mm aa");
        try {
            return new Time(format.parse(t).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }





}
