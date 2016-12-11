package com.cosc457;

import com.cosc457.data.AvailabilityApi;
import com.cosc457.data.EmployeeApi;
import com.cosc457.models.*;
import com.cosc457.util.DateUtil;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by donnie on 12/2/16.
 */
public class ScheduleBuilder {

    private ArrayList<Employee> employees;
    private ArrayList<Availability> availabilities;
    private ArrayList<WorkDay> workdays;
    public ScheduleBuilder(){
        employees = EmployeeApi.getAllEmployees();
        availabilities = AvailabilityApi.getAllAvailabilities();
        workdays = WorkDay.getWorkDays();
    }

    public void build(){
        for(WorkDay day : workdays){
            for(Availability a : availabilities){
                if(a.getWeekDay() == day.getDay()){
                    for(double startTime = DateUtil.get100OffsetTime(a.getStartTime()); startTime < DateUtil.get100OffsetTime(a.getEndTime()); startTime+=.25){
                        if(day.needsFilled(startTime)){
                            day.fill(startTime, a);
                        }
                    }
                }
            }
            day.printPretty();
        }
    }

    public void condense(){
        ArrayList<Shift> shifts = new ArrayList<Shift>();
        for(WorkDay w : workdays){
            HashMap<Double, AvailabilityBundle> timeMap = w.getAvailabilityMap();
            for(Double d : timeMap.keySet()){
                AvailabilityBundle bundle = timeMap.get(d);
                Availability managerAvailability = bundle.getManager();
                Availability staffAvailability = bundle.getStaff();
                Shift managerShift = new Shift(managerAvailability.getEmployeeID(),w.getDay(), DateUtil.getTimeFromDouble(d), DateUtil.getTimeFromDouble(d+.25));
                Shift staffShift = new Shift(staffAvailability.getEmployeeID(), w.getDay(), DateUtil.getTimeFromDouble(d), DateUtil.getTimeFromDouble(d+.25));
                
                /*
                int firstId = bundle.getManager().getEmployeeID();
                double startTimeKey = d;
                double endTimeKey = d+.25;
                boolean isNext = true;
                do{
                   double nextKey = startTimeKey+.25;
                   if(timeMap.get(nextKey).getManager().getEmployeeID() == firstId){
                       endTimeKey = nextKey;
                       timeMap.get(nextKey).removeManager();
                       endTimeKey=+.25;
                   }
                }while(isNext);
                */

                bundle.getManager().getStartTime();
            }
        }
    }



}
