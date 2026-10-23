package com.uqu.sgm.controllers;

import com.uqu.sgm.models.Grade;
import com.uqu.sgm.models.Student;
import com.uqu.sgm.utils.FileManager;
import com.uqu.sgm.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

// Controller for the View Reports window (bonus)
public class ViewReportsController implements Initializable {

    @FXML private TextArea reportArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Student> students = FileManager.loadStudents();
        List<Grade> grades = FileManager.loadGrades();

        StringBuilder report = new StringBuilder();
        report.append("===== STUDENT GRADE REPORT =====\n\n");
        report.append("Total students: ").append(students.size()).append("\n");
        report.append("Total grades recorded: ").append(grades.size()).append("\n\n");

        // overall average of all grades
        double sum = 0;
        for (Grade g : grades) {
            sum += g.getScore();
        }
        double overallAverage = grades.isEmpty() ? 0 : sum / grades.size();
        report.append(String.format("Overall average grade: %.2f%n%n", overallAverage));

        // average per student
        report.append("Average per student:\n");
        report.append("--------------------------------\n");
        for (Student s : students) {
            double average = FileManager.averageForStudent(s.getId());
            report.append(String.format("%s (%s): %.2f%n", s.getName(), s.getId(), average));
        }

        reportArea.setText(report.toString());
    }

    @FXML
    private void goBack(ActionEvent event) {
        Navigator.switchTo(event, "/fxml/Dashboard.fxml");
    }
}
