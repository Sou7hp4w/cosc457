package com.cosc457.models;

import java.sql.Time;

/**
 * Created by donnie on 12/11/16.
 */
public class Shift {
    private int ID;
    private int employeeID;
    private int weekDay;
    private Time startTime;
    private Time endTime;

    public Shift(int employeeID,int weekDay, Time startTime, Time endTime) {
        this.employeeID = employeeID;
        this.weekDay = weekDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Shift(int ID, int employeeID, int weekDay, Time startTime, Time endTime) {
        this.ID = ID;
        this.employeeID = employeeID;
        this.weekDay = weekDay;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
