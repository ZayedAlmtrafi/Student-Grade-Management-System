package com.uqu.sgm.controllers;

import com.uqu.sgm.models.Student;
import com.uqu.sgm.utils.FileManager;
import com.uqu.sgm.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// Controller for the Add Student window
public class AddStudentController {

    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private Label messageLabel;

    @FXML
    private void handleAdd(ActionEvent event) {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();

        if (id.isEmpty() || name.isEmpty()) {
            messageLabel.setText("Please fill in all fields.");
            return;
        }

        if (FileManager.studentExists(id)) {
            messageLabel.setText("A student with this ID already exists.");
            return;
        }

        FileManager.saveStudent(new Student(id, name));
        messageLabel.setText("Student added successfully.");
        idField.clear();
        nameField.clear();
    }

    @FXML
    private void goBack(ActionEvent event) {
        Navigator.switchTo(event, "/fxml/Dashboard.fxml");
    }
}
