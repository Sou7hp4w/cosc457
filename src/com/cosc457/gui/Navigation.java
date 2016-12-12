package com.cosc457.gui;

import com.cosc457.ScheduleBuilder;
import com.cosc457.data.SeedData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

/**
 * Created by donnie on 11/30/16.
 */
public class Navigation extends JPanel{

    JPanel navigationPanel = new JPanel();
    AddEmployee addEmployee = new AddEmployee();
    DeleteEmployee deleteEmplyoee = new DeleteEmployee();
    ViewEmployee viewEmployee = new ViewEmployee();
    AddAvailability addAvailability = new AddAvailability();
    ViewAvailability viewAvailability = new ViewAvailability();
    CreateSchedule createSchedule = new CreateSchedule();
    ViewSchedules viewSchedules = new ViewSchedules();

    public static Navigation INSTANCE;
    private JButton addEmployeeButton;
    private JButton deleteEmployeeButton;
    private JButton viewEmployeesButton;
    private JButton addAvailabilityButton;
    private JButton viewAvailabilityButton;
    private JButton createScheduleButton;
    private JButton viewSchedulesButton;

    private JButton generateSeedDataButton;

    private Navigation(){
        super(new BorderLayout());
        createMenu();
        add(navigationPanel);
        navigationPanel.setSize(500,500);
        initListeners();
    }

    public static Navigation getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Navigation();
        }
        return INSTANCE;
    }

    private void createMenu(){
        addEmployeeButton = new JButton("Add Employee");
        deleteEmployeeButton = new JButton("Delete Employee");
        viewEmployeesButton = new JButton("View Employees");
        addAvailabilityButton = new JButton("Add Availability");
        viewAvailabilityButton = new JButton("View Availability");
        generateSeedDataButton = new JButton("Generate Seed Data");
        createScheduleButton = new JButton("Create Schedule");
        viewSchedulesButton = new JButton("View Schedule");
        navigationPanel.add(addEmployeeButton);
        navigationPanel.add(deleteEmployeeButton);
        navigationPanel.add(viewEmployeesButton);
        navigationPanel.add(addAvailabilityButton);
        navigationPanel.add(viewAvailabilityButton);
        navigationPanel.add(generateSeedDataButton);
        navigationPanel.add(createScheduleButton);
        navigationPanel.add(viewSchedulesButton);
    }

    private void initListeners(){
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(addEmployee.getPanel());
                redraw();
            }
        });
        deleteEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(deleteEmplyoee.getPanel());
                redraw();
            }
        });
        viewEmployeesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(viewEmployee.getPanel());
                viewEmployee.load();
                redraw();
            }
        });
        addAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(addAvailability.getPanel());
                addAvailability.load();
                redraw();
            }
        });
        viewAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(viewAvailability.getPanel());
                viewAvailability.load();
                redraw();
            }
        });
        generateSeedDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SeedData.seed();
                JLabel done = new JLabel("Done - seed data has been generated");
                navigationPanel.add(done);
            }
        });
        createScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(createSchedule.getPanel());
                createSchedule.load();
                redraw();
            }
        });
        viewSchedulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove(getComponent(0));
                add(viewSchedules.getPanel());
                viewSchedules.load();
                redraw();
            }
        });
    }

    public void goBack(JPanel p){
       remove(p);
        add(navigationPanel);
        redraw();
    }

    public void replace(JPanel panel){
        remove(getComponent(0));
        add(panel);
        redraw();

    }

    public void redraw(){
        repaint();
        revalidate();
    }


}
