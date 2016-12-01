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

    public Employee(){

    }

    public Employee(String firstName, String lastName, int maxHours){
        this.firstName = firstName;
        this.lastName = lastName;
        this.maxHours = maxHours;
    }
    public Employee(String firstName, String lastName, int maxHours, int ID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.maxHours = maxHours;
        this.ID = ID;
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
    public String getFullName(){
        return firstName + " " + lastName;
    }



    @Override
    public String toString(){
        return "Name: " + firstName + " " + lastName + " Max Hours: " + maxHours;
    }

}
