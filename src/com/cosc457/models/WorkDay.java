package com.cosc457.models;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by donnie on 12/2/16.
 */
public class WorkDay {
    private int day;
    private HashMap<Double,Availability> hours;
    public WorkDay(int number){
        day = number;
        genMap();
    }

    private void genMap(){
        for(double i = 7; i < 18; i = i+.25){
            hours.put(i, null);
        }
    }

    public void scheduleEmployee(Availability a){

    }


    public int getDay() {
        return day;
    }

    public boolean needsFilled(Availability a){
        ArrayList<Integer> availableHours = new ArrayList<Integer>();
        for(int start = a.getStartTime().getHours(); start < a.getEndTime().getHours(); start++){
            availableHours.add(start);
        }
        for(int hour : availableHours){
            if(hours.get(hour) != null){
               // hours.put(hour, a);
            }
        }

        return false;
    }

    public static ArrayList<WorkDay> getWorkDays(){
        ArrayList<WorkDay> days = new ArrayList<WorkDay>();
        days.add(new WorkDay(DayOfWeek.MONDAY.getValue()));
        days.add(new WorkDay(DayOfWeek.TUESDAY.getValue()));
        days.add(new WorkDay(DayOfWeek.WEDNESDAY.getValue()));
        days.add(new WorkDay(DayOfWeek.THURSDAY.getValue()));
        days.add(new WorkDay(DayOfWeek.FRIDAY.getValue()));

        return days;
    }
}
