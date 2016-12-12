package com.cosc457.data;

import com.cosc457.models.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by donnie on 11/30/16.
 */
public class EmployeeApi {
    private static Database database = Database.getInstance();

    public static void saveEmployee(Employee e){
        String values = "'"+e.getFirstName() + "', '" + e.getLastName() + "'," + e.getMaxHours()+ ", "+e.isManager() + "";
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO EMPLOYEE(firstName, lastName, maxHours, isManager) VALUES("+values+");");
        try {
            database.insert(query.toString());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void deleteEmployee(Employee e){
        String first_name = e.getFirstName();
        String last_name = e.getLastName();
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM EMPLOYEE WHERE firstName ='"+first_name+"' AND lastName ='"+last_name+"';");
        try {
            database.insert(query.toString());
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    public static ArrayList<Employee> getAllEmployees(){
        ArrayList<Employee> result = new ArrayList<Employee>();
        String query = "SELECT * FROM EMPLOYEE";
        try {
            for(Object o : database.retrieve(query, Employee.class)){
               result.add((Employee)o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Employee getById(int id){
        String query = "SELECT * FROM EMPLOYEE WHERE ID = " + id;
        try {
            for(Object o : database.retrieve(query, Employee.class)){
                return (Employee)o;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Employee getEmployeeByName(String name){
        for(Employee e : EmployeeApi.getAllEmployees()){
            if(e.getFullName().equals(name)){
                return e;
            }
        }
        return null;
    }

    public static HashMap<Integer, Employee> getEmployeeIdMap(){
        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
        for(Employee e : getAllEmployees()){
            map.put(e.getID(), e);
        }
        return map;
    }

}
