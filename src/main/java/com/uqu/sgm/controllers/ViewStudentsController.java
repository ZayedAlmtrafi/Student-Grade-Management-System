package com.uqu.sgm.controllers;

import com.uqu.sgm.models.Grade;
import com.uqu.sgm.models.Student;
import com.uqu.sgm.utils.FileManager;
import com.uqu.sgm.utils.Navigator;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

// Controller for the View Students window
public class ViewStudentsController implements Initializable {

    @FXML private TableView<Student> studentsTable;
    @FXML private TableColumn<Student, String> idColumn;
    @FXML private TableColumn<Student, String> nameColumn;
    @FXML private TableColumn<Student, String> averageColumn;
    @FXML private ListView<String> gradesList;

    // runs when the window opens
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // tell the ID and Name columns which field of Student to show
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // the Average column is calculated for each row
        averageColumn.setCellValueFactory(cell -> {
            Student student = cell.getValue();
            double average = FileManager.averageForStudent(student.getId());
            return new SimpleStringProperty("" + average);
        });

        // load all students into the table
        List<Student> students = FileManager.loadStudents();
        studentsTable.setItems(FXCollections.observableArrayList(students));
    }

    // called when a student row is clicked
    @FXML
    private void showGrades() {
        Student selected = studentsTable.getSelectionModel().getSelectedItem();
        gradesList.getItems().clear();

        if (selected == null) {
            return;
        }

        List<Grade> grades = FileManager.gradesForStudent(selected.getId());
        if (grades.isEmpty()) {
            gradesList.getItems().add("No grades recorded.");
        } else {
            for (Grade g : grades) {
                gradesList.getItems().add(g.getSubject() + " : " + g.getScore());
            }
        }
    }

    @FXML
    private void goBack(ActionEvent event) {
        Navigator.switchTo(event, "/fxml/Dashboard.fxml");
    }
}
