package com.cosc457.gui;

import com.cosc457.data.EmployeeApi;
import com.cosc457.models.Employee;
import com.cosc457.util.DateUtil;

import javax.swing.*;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by donnie on 11/30/16.
 */
public class AddAvailability extends JPanel {
    private JSpinner employeeSpinner;
    private JPanel panel;
    private JButton backButton;
    private JSpinner weekDaySpinner;
    private JSpinner endTimeSpinner;
    private JSpinner startTimeSpinner;
    private JButton saveAndAddAnotherButton;

    public AddAvailability(){
        ArrayList<String> employeeNames = new ArrayList<String>();
        for(Employee e : EmployeeApi.getAllEmployees()){
            employeeNames.add(e.getFullName());
        }
        SpinnerListModel names = new SpinnerListModel(employeeNames);
        employeeSpinner.setModel(names);

        SpinnerListModel days = new SpinnerListModel(DateUtil.getWeekdays());
        weekDaySpinner.setModel(days);
        startTimeSpinner.setModel( new SpinnerListModel(DateUtil.getTimes()));
        endTimeSpinner.setModel( new SpinnerListModel(DateUtil.getTimes()));

        setupSaveButton();
    }

    public JPanel getPanel(){
        return panel;
    }

    private void setupSaveButton(){
        int id = EmployeeApi.getEmployeeByName(employeeSpinner.getValue().toString()).getID();
        int weekday = DateUtil.getWeekdays().indexOf(weekDaySpinner.getValue());
        //Time startTime = new Time(startTimeSpinner.getValue().toString());
        //new AddAvailability(, , startTimeSpinner.getValue().toString(), endTimeSpinner.getValue().toString());
    }


}
