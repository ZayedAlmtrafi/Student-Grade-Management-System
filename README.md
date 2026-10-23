# Student Grade Management System

**Advanced Programming Course Project | Second-Year Computer Science | Umm Al-Qura University**

## About the Project

This desktop application was developed as a project for my **Advanced Programming** course during my second year of Computer Science. It uses **Java** and **JavaFX** to manage student records, record grades, and generate basic academic reports.

The purpose of the project was to apply programming concepts learned in the course, including object-oriented programming, graphical user interfaces, input validation, and file handling.

## Features

- **Admin login:** Access the application through a simple login screen.
- **Student management:** Add students with an ID and name, with validation for empty fields and duplicate IDs.
- **Grade management:** Record student grades and validate scores from 0 to 100.
- **Student overview:** View student records, recorded grades, and average scores.
- **Academic reports:** View the total number of students and grades, overall grade average, and average grade for each student.
- **Local file storage:** Save and load records using text files.

## Technologies Used

- **Java 17** — Application logic and object-oriented programming
- **JavaFX 21.0.2** — Desktop graphical user interface
- **FXML and CSS** — UI layouts and styling
- **Apache Maven** — Project build and dependency management
- **Java File I/O** — Local data storage

## Course Concepts Applied

- Object-oriented programming with classes and objects
- Separating application logic, models, and GUI controllers
- Event-driven programming with JavaFX
- Input validation and error handling
- Reading and writing data to local files
- Working with collections and calculating grade averages

## How to Run

### Requirements

- JDK 17 or newer
- Apache Maven

### Steps

1. Download or clone this repository.
2. Open the project folder containing `pom.xml` in a terminal.
3. Run:

   ```bash
   mvn javafx:run
   ```

Maven will download the required JavaFX dependencies if needed, then launch the application.

**Demo login:**

- Username: `admin`
- Password: `admin`

> **Note:** The login credentials are hardcoded for this course demonstration. They do not provide production-level security.

## Project Structure

```text
src/
└── main/
    ├── java/com/uqu/sgm/
    │   ├── Main.java
    │   ├── controllers/       # JavaFX screen controllers
    │   ├── models/            # Student and grade models
    │   └── utils/             # File handling and navigation
    └── resources/
        ├── fxml/              # Interface layouts
        └── css/               # Interface styling
data/                          # Local text-file records
pom.xml                        # Maven configuration
```

## Data Storage

Student records and grades are stored locally in `data/students.txt` and `data/grades.txt`. The application accesses these files relative to its working directory, so run the command from the project root.

When sharing this project publicly, use fictional sample student data rather than real student information.

## Academic Project Note

This repository is a **second-year Advanced Programming course project**, created for educational purposes to demonstrate Java programming and application-development concepts. It is not intended to be a production-ready student information system.
