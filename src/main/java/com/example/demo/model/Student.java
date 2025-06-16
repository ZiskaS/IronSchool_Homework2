package com.example.demo.model;

public class Student {
    // Static counter to generate unique student IDs
    private static int idCounter = 0;

    // Private attributes
    private final String studentId;
    private String name;
    private String address;
    private String email;
    private Course course; // Nullable

    // Constructor that initializes name, address, and email, and auto-generates ID
    public Student(String name, String address, String email) {
        this.studentId = "S" + (++idCounter);
        this.setName(name);
        this.setAddress(address);
        this.setEmail(email);
        this.course = null;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Course getCourse() {
        return course;
    }

    // Setters with validation
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty.");
        }
        this.name = name;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be empty.");
        }
        this.address = address;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email.");
        }
        this.email = email;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // Optional: toString method for easy printing
    @Override
    public String toString() {
        return "Student ID: " + studentId +
                ", Name: " + name +
                ", Address: " + address +
                ", Email: " + email +
                ", Course: " + (course != null ? course.getName() : "None");
    }
}
