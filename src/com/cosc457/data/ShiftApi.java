package com.cosc457.data;

import com.cosc457.models.Shift;

import java.sql.SQLException;

/**
 * Created by donnie on 12/11/16.
 */
public class ShiftApi {
    private static Database database = Database.getInstance();
    public static void saveShift(Shift s){
        String values = " '"+s.getEmployeeID() + "', '" + s.getScheduleID() + "', '"+s.getWeekDay()+"','"+s.getStartTime()+"','"+s.getEndTime()+"'";
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO SHIFT(employeeID, scheduleID, workDay, startTime, endTime) VALUES("+values+");");
        try {
            database.insert(query.toString());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
