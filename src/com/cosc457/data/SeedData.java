package com.cosc457.data;

import java.sql.SQLException;

/**
 * Created by donnie on 12/11/16.
 */
public class SeedData {

    private static Database db;
    public static void seed(){
        db = Database.getInstance();
        seedEmployee();
        seedAvailability();

    }
    private static void seedEmployee(){
        try {
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Meredith', 'Price',20, true);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('John', 'Doe',20, true);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('James', 'Test',20, false);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Sarah', 'Aye',20, false);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Jane', 'Doe',20, false);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Megan', 'Price',20, false);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Maddie', 'Test',20, true);");
            db.insert("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES('Ash', 'Catchum',20, true);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void seedAvailability(){
        try {
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('1', '1','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('2', '1','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('3', '1','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('4', '1','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('1', '2','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('2', '2','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('3', '2','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('4', '2','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('1', '3','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('2', '3','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('3', '3','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('4', '3','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('1', '4','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('2', '4','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('3', '4','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('4', '4','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('1', '5','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('2', '5','07:00:00','12:00:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('3', '5','12:00:00','19:30:00');");
            db.insert("INSERT INTO EMPLOYEE_AVAILABILITY(employeeID, weekDay, startTime, endTime) VALUES('4', '5','12:00:00','19:30:00');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
