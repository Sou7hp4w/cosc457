package com.cosc457;

import com.cosc457.data.AvailabilityApi;
import com.cosc457.data.EmployeeApi;
import com.cosc457.models.Availability;
import com.cosc457.models.Employee;
import com.cosc457.models.Schedule;
import com.cosc457.models.WorkDay;

import java.util.ArrayList;

/**
 * Created by donnie on 12/2/16.
 */
public class ScheduleBuilder {

    private ArrayList<Employee> employees;
    private ArrayList<Availability> availabilities;

    public ScheduleBuilder(){
        employees = EmployeeApi.getAllEmployees();
        availabilities = AvailabilityApi.getAllAvailabilities();
    }

    public void build(){

    }

    private void breakdown(){
        for(WorkDay day : WorkDay.getWorkDays()){
            for(Availability a : availabilities){
                if(a.getWeekDay() == day.getDay()){
                    if(day.needsFilled(a)){

                    }
                }
            }
        }
    }



}
