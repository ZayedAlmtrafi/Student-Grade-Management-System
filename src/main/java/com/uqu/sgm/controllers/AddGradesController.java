package com.uqu.sgm.controllers;

import com.uqu.sgm.models.Grade;
import com.uqu.sgm.models.Student;
import com.uqu.sgm.utils.FileManager;
import com.uqu.sgm.utils.Navigator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

// Controller for the Add Grades window
public class AddGradesController implements Initializable {

    @FXML private ComboBox<Student> studentCombo;
    @FXML private TextField subjectField;
    @FXML private TextField scoreField;
    @FXML private Label messageLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentCombo.setItems(FXCollections.observableArrayList(FileManager.loadStudents()));
    }

    @FXML
    private void handleAdd(ActionEvent event) {
        Student selected = studentCombo.getValue();
        String subject = subjectField.getText().trim();
        String scoreText = scoreField.getText().trim();

        if (selected == null || subject.isEmpty() || scoreText.isEmpty()) {
            messageLabel.setText("Please fill in all fields.");
            return;
        }

        double score;
        try {
            score = Double.parseDouble(scoreText);
        } catch (NumberFormatException e) {
            messageLabel.setText("Score must be a number.");
            return;
        }

        if (score < 0 || score > 100) {
            messageLabel.setText("Score must be between 0 and 100.");
            return;
        }

        FileManager.saveGrade(new Grade(selected.getId(), subject, score));
        messageLabel.setText("Grade added successfully.");
        subjectField.clear();
        scoreField.clear();
    }

    @FXML
    private void goBack(ActionEvent event) {
        Navigator.switchTo(event, "/fxml/Dashboard.fxml");
    }
}
