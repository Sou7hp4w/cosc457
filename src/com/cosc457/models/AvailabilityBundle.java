package com.cosc457.models;

/**
 * Created by donnie on 12/10/16.
 */
public class AvailabilityBundle {

    private Availability manager;
    private Availability staff;

    public AvailabilityBundle(){

    }
    public boolean needsManager(){
        return manager == null;
    }
    public boolean needsStaff(){
        return staff == null;
    }
    public void setManager(Availability manager){
        this.manager = manager;
    }
    public void setStaff(Availability staff){
        this.staff = staff;
    }

    public boolean needsFilled(){
        if(manager == null || staff == null)
            return true;
        return false;
    }

    @Override
    public String toString(){
        if(manager != null && staff != null)
         return "Manager: " + manager.toString() + "\n " + "Staff: " + staff.toString();
        return "Null";
    }
    //public AvailabilityBundle

}
