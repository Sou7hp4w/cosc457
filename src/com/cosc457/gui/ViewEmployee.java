package com.cosc457.gui;

import com.cosc457.data.Database;
import com.cosc457.data.EmployeeApi;
import com.cosc457.models.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by donnie on 11/30/16.
 */
public class ViewEmployee extends JPanel{
    private JPanel panel1;
    private JButton backButton;
    private JScrollPane employees;

    public ViewEmployee(){
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
    public void load(){
        JPanel wrapper = new JPanel();
        StringBuilder content = new StringBuilder("<html>");
        for(Employee e : EmployeeApi.getAllEmployees()){
            content.append("<p>" + e.toString() + "</p><br>");
        }
        content.append("</html>");
        wrapper.add(new JLabel(content.toString()));
        employees.getViewport().add(wrapper);
    }



}
