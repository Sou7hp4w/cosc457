package com.cosc457.gui;

import com.cosc457.data.EmployeeApi;
import com.cosc457.models.Employee;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
    private JCheckBox managerEmployeeCheckBox;

    public AddEmployee(){
        initSaveButton();
        saveButton.setEnabled(false);

        firstNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            private void changed()
            {
                if (firstNameField.getText().equals("") || lastNameField.getText().equals("") || hoursField.getText().equals(""))
                {
                    saveButton.setEnabled(false);
                }
                else
                {
                    saveButton.setEnabled(true);
                }
            }
        });

        lastNameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            private void changed()
            {
                if (firstNameField.getText().equals("") || lastNameField.getText().equals("") || hoursField.getText().equals(""))
                {
                    saveButton.setEnabled(false);
                }
                else
                {
                    saveButton.setEnabled(true);
                }
            }
        });

        hoursField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            private void changed()
            {
                if (firstNameField.getText().equals("") || lastNameField.getText().equals("") || hoursField.getText().equals(""))
                {
                    saveButton.setEnabled(false);
                }
                else
                {
                    saveButton.setEnabled(true);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               Navigation.getInstance().goBack(panel1);
            }
        });
    }

    public JPanel getPanel(){
        return panel1;
    }

    private void initSaveButton(){
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int max_hours = Integer.parseInt(hoursField.getText());

                if (max_hours > 20)
                {
                    JOptionPane.showMessageDialog(null, "Employees can only work a maximum of 20 hours.");
                }
                else {
                    EmployeeApi.saveEmployee(new Employee(firstNameField.getText(), lastNameField.getText(), Integer.parseInt(hoursField.getText()), managerEmployeeCheckBox.isSelected()));
                }
            }
        });
    }
}
