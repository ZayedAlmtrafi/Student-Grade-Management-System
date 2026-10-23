package com.uqu.sgm.controllers;

import com.uqu.sgm.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

// Controller for the Dashboard window
public class DashboardController {

    @FXML
    private void goAddStudent(ActionEvent event) {
        Navigator.switchTo(event, "/fxml/AddStudent.fxml");
    }

    @FXML
    private void goAddGrades(ActionEvent event) {
        Navigator.switchTo(event, "/fxml/AddGrades.fxml");
    }

    @FXML
    private void goViewStudents(ActionEvent event) {
        Navigator.switchTo(event, "/fxml/ViewStudents.fxml");
    }

    @FXML
    private void goViewReports(ActionEvent event) {
        Navigator.switchTo(event, "/fxml/ViewReports.fxml");
    }

    @FXML
    private void logout(ActionEvent event) {
        Navigator.switchTo(event, "/fxml/Login.fxml");
    }
}
