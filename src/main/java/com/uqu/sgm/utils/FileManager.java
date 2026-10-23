package com.uqu.sgm.utils;

import com.uqu.sgm.models.Grade;
import com.uqu.sgm.models.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Handles all file input/output for students and grades
public class FileManager {

    private static final String STUDENTS_FILE = "data/students.txt";
    private static final String GRADES_FILE = "data/grades.txt";

    // Make sure the data folder exists before writing
    private static void ensureDataDir() {
        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    // ---------- Students ----------

    public static void saveStudent(Student student) {
        ensureDataDir();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STUDENTS_FILE, true))) {
            writer.write(student.getId() + "," + student.getName());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        File file = new File(STUDENTS_FILE);
        if (!file.exists()) {
            return students;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",", 2);
                if (parts.length >= 2) {
                    students.add(new Student(parts[0].trim(), parts[1].trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static boolean studentExists(String id) {
        for (Student s : loadStudents()) {
            if (s.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    // ---------- Grades ----------

    public static void saveGrade(Grade grade) {
        ensureDataDir();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(GRADES_FILE, true))) {
            writer.write(grade.getStudentId() + "," + grade.getSubject() + "," + grade.getScore());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Grade> loadGrades() {
        List<Grade> grades = new ArrayList<>();
        File file = new File(GRADES_FILE);
        if (!file.exists()) {
            return grades;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    try {
                        double score = Double.parseDouble(parts[2].trim());
                        grades.add(new Grade(parts[0].trim(), parts[1].trim(), score));
                    } catch (NumberFormatException ignored) {
                        // skip a bad line instead of crashing
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grades;
    }

    public static List<Grade> gradesForStudent(String studentId) {
        List<Grade> result = new ArrayList<>();
        for (Grade g : loadGrades()) {
            if (g.getStudentId().equalsIgnoreCase(studentId)) {
                result.add(g);
            }
        }
        return result;
    }

    // Calculate the average grade for one student
    public static double averageForStudent(String studentId) {
        List<Grade> grades = gradesForStudent(studentId);
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Grade g : grades) {
            sum += g.getScore();
        }
        return sum / grades.size();
    }
}
