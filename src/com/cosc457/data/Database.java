package com.cosc457.data;

import com.cosc457.models.Availability;
import com.cosc457.models.Employee;

import javax.swing.plaf.nimbus.State;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by donnie on 11/30/16.
 */
public class Database {

    private static Database INSTANCE;
    private Connection connection;

    private Database(){

    }

    public static Database getInstance(){
       if(INSTANCE == null){
           INSTANCE = new Database();
       }
        return INSTANCE;
    }

    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://database-cosc.clb79rzeap7g.us-west-2.rds.amazonaws.com:3306", "prodion23", "c29tZWdhcmJhZ2U=");
            connection.setSchema("scheduler");
        }catch(Exception e){
            System.out.println(e);
        }

    }

    public void initializeDatabase() throws SQLException {
        String check = "SHOW TABLES LIKE 'EMPLOYEE';";
        String employeeCreation = "CREATE TABLE EMPLOYEE(ID INT AUTO_INCREMENT NOT NULL,firstName VARCHAR(45),lastName VARCHAR(45),maxHours VARCHAR(45),PRIMARY KEY(ID));";
        String employeeAvailability = "CREATE TABLE EMPLOYEE_AVAILABILITY(ID INT AUTO_INCREMENT NOT NULL,employeeID INT,weekDay INT(1),startTime time,endTime time,PRIMARY KEY(ID),FOREIGN KEY(employeeID) REFERENCES EMPLOYEE(ID));";
        String scheduleCreation = "CREATE TABLE SCHEDULE(ID INT AUTO_INCREMENT NOT NULL,startDate date,endDate date,PRIMARY KEY(ID));";
        String shiftCreation = "CREATE TABLE SHIFT(ID INT AUTO_INCREMENT NOT NULL,employeeID INT,scheduleID INT,workDate date,startTime time,endTime time,PRIMARY KEY(ID),FOREIGN KEY(employeeID) REFERENCES EMPLOYEE(ID),FOREIGN KEY(scheduleID) REFERENCES SCHEDULE(ID));";
        Statement stmt=connection.createStatement();
        stmt.execute("use scheduler");
        ResultSet set = stmt.executeQuery(check);
        boolean exists = set.next();
        if(!exists){ //Initialize the db if it doesn't exist
            stmt.execute(employeeCreation);
            stmt.execute(employeeAvailability);
            stmt.execute(scheduleCreation);
            stmt.execute(shiftCreation);
        }
    }

    public void insert(String query) throws SQLException{
        System.out.println(query);
        Statement stmt = connection.createStatement();
        stmt.execute(query);
    }

    public ArrayList<Object> retrieve(String query, Class<?> type) throws SQLException{
        ArrayList<Object> results = new ArrayList<Object>();

        Statement stmt = connection.createStatement();
        ResultSet set = stmt.executeQuery(query);
        while(set.next()){
            if(type.equals(Employee.class)){
                results.add(parseEmployee(set));
            }else if(type.equals(Availability.class)){
                results.add(parseAvailability(set));
            }

        }
        return results;
    }


    private Employee parseEmployee(ResultSet set) throws SQLException {
        return new Employee(set.getString("firstName"), set.getString("lastName"), set.getInt("maxHours"), set.getInt("ID"));
    }
    private Availability parseAvailability(ResultSet set) throws SQLException{
        return new Availability(set.getInt("ID"), set.getInt("employeeID"),set.getInt("weekDay"), set.getTime("startTime"), set.getTime("endTime"));
    }

}
