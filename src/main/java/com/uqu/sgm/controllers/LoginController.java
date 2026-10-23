package com.uqu.sgm.controllers;

import com.uqu.sgm.utils.Navigator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

// Controller for the Login window
public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        // Only admin can log in
        if (username.equals("admin") && password.equals("admin")) {
            Navigator.switchTo(event, "/fxml/Dashboard.fxml");
        } else {
            messageLabel.setText("Invalid username or password.");
        }
    }
}
