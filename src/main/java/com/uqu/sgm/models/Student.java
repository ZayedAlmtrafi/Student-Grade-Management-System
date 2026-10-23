package com.uqu.sgm.models;

// Model class that represents a single student
public class Student {

    private String id;
    private String name;
    private double average;   // used only to show the average in the table

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
