package com.cosc457.models;

import com.cosc457.data.EmployeeApi;

/**
 * Created by donnie on 11/30/16.
 */
public class Employee {
    private String firstName;
    private String lastName;
    private int maxHours;
    private int ID;
    private boolean isManager;

    public Employee(){

    }

    public Employee(String firstName, String lastName, int maxHours, boolean isManager){
        this.firstName = firstName;
        this.lastName = lastName;
        this.maxHours = maxHours;
        this.isManager = isManager;
    }

    public Employee(String firstName, String lastName, int maxHours, int ID, boolean isManager){
        this.firstName = firstName;
        this.lastName = lastName;
        this.maxHours = maxHours;
        this.ID = ID;
        this.isManager = isManager;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getMaxHours() {
        return maxHours;
    }

    public int getID() {
        return ID;
    }
    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean isManager) {
        this.isManager = isManager;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }



    @Override
    public String toString(){
        return "Name: " + firstName + " " + lastName + " Max Hours: " + maxHours;
    }

}
