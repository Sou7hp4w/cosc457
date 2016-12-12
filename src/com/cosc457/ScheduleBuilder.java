package com.cosc457;

import com.cosc457.data.*;
import com.cosc457.models.*;
import com.cosc457.util.DateUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by donnie on 12/2/16.
 */
public class ScheduleBuilder {

    private ArrayList<Employee> employees;
    private ArrayList<Availability> availabilities;
    private ArrayList<WorkDay> workdays;
    private Schedule schedule;
    private JProgressBar progressBar;
    public ScheduleBuilder(Date startDate, Date endDate, JProgressBar progressBar){
        schedule = new Schedule(startDate, endDate);
        this.progressBar = progressBar;
        ScheduleApi.saveSchedule(schedule);
        schedule = ScheduleApi.getSchedule(schedule.getStartDate(), schedule.getEndDate());
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
            progressBar.setValue(progressBar.getValue()+5);
        }
        condense();
    }

    public void condense(){
        ArrayList<Shift> shifts = new ArrayList<Shift>();
        for(WorkDay w : workdays){
            HashMap<Double, AvailabilityBundle> timeMap = w.getAvailabilityMap();
            for(Double d : timeMap.keySet()){
                AvailabilityBundle bundle = timeMap.get(d);
                Availability managerAvailability = bundle.getManager();
                Availability staffAvailability = bundle.getStaff();
                Shift managerShift = null;
                Shift staffShift = null;
                if(managerAvailability != null){
                   managerShift = new Shift(managerAvailability.getEmployeeID(),w.getDay(),schedule.getID(), DateUtil.getTimeFromDouble(d), DateUtil.getTimeFromDouble(d + .25));
                }
                if(staffAvailability != null){
                    staffShift = new Shift(staffAvailability.getEmployeeID(), w.getDay(),schedule.getID(), DateUtil.getTimeFromDouble(d), DateUtil.getTimeFromDouble(d+.25));
                }
                boolean recurse = true;
                double nextKey = d;
                while(recurse){
                    nextKey = nextKey+.25;
                    recurse = false;
                    if(timeMap.get(nextKey) != null){
                        AvailabilityBundle nextBundle = timeMap.get(nextKey);
                        if(managerAvailability != null && nextBundle.containsEmployee(managerAvailability.getEmployeeID())){
                            recurse = true;
                            managerShift.setEndTime(DateUtil.getTimeFromDouble(nextKey+.25));
                            nextBundle.removeFromBundle(managerAvailability.getEmployeeID());
                        }
                        if(staffAvailability != null && nextBundle.containsEmployee(staffAvailability.getEmployeeID())){
                            recurse = true;
                            staffShift.setEndTime(DateUtil.getTimeFromDouble(nextKey+.25));
                            nextBundle.removeFromBundle(staffAvailability.getEmployeeID());
                        }
                    }else{
                        System.out.println("NEXT IS NULL " + nextKey);
                        recurse = false;
                    }
                }
                if(managerShift != null){
                    shifts.add(managerShift);
                }
                if(staffShift != null){
                    shifts.add(staffShift);
                }
            }
        }

        for(Shift s : shifts){
            ShiftApi.saveShift(s);
        }

        System.out.println("DONE");

    }



}
