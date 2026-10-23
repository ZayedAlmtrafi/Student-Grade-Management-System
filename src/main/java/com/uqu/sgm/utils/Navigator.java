package com.uqu.sgm.utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

// Handles navigation (scene switching) between the windows
public class Navigator {

    public static void switchTo(ActionEvent event, String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(Navigator.class.getResource(fxmlPath));
            Node node = (Node) event.getSource();
            // keep the same window and just replace its content
            node.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
