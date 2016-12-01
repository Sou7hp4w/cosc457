package com.cosc457.gui;

import com.cosc457.data.EmployeeApi;
import com.cosc457.models.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by donnie on 11/30/16.
 */
public class AddEmployee extends JPanel{
    private JPanel panel1;
    private JLabel fNLabel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField hoursField;
    private JButton saveButton;
    private JButton backButton;

    public AddEmployee(){
        initSaveButton();
    }

    public JPanel getPanel(){
        return panel1;
    }
    private void initSaveButton(){
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EmployeeApi.saveEmployee(new Employee(firstNameField.getText(), lastNameField.getText(), Integer.parseInt(hoursField.getText())));
            }
        });
    }
}
