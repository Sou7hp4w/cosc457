package com.cosc457.gui;

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
    ViewEmployee viewEmployee = new ViewEmployee();
    AddAvailability addAvailability = new AddAvailability();
    ViewAvailability viewAvailability = new ViewAvailability();

    public static Navigation INSTANCE;
    private JButton addEmployeeButton;
    private JButton viewEmployeesButton;
    private JButton addAvailabilityButton;
    private JButton viewAvailabilityButton;

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
        viewEmployeesButton = new JButton("View Employees");
        addAvailabilityButton = new JButton("Add Availability");
        viewAvailabilityButton = new JButton("View Availability");
        navigationPanel.add(addEmployeeButton);
        navigationPanel.add(viewEmployeesButton);
        navigationPanel.add(addAvailabilityButton);
        navigationPanel.add(viewAvailabilityButton);
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
    }

    public void goBack(JPanel p){
       remove(p);
        add(navigationPanel);
        redraw();
    }

    public void redraw(){
        repaint();
        revalidate();
    }


}
