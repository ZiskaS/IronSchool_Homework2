package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {

    @Test
    void testTeacherNameValidation() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Teacher("", 1000));
        assertEquals("Name cannot be empty.", ex.getMessage());
    }

    @Test
    void testTeacherSalaryValidation() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Teacher("Luis", -10));
        assertEquals("Salary cannot be negative.", ex.getMessage());
    }

    @Test
    void testCourseNameValidation() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Course("", 200));
        assertEquals("Course name cannot be empty.", ex.getMessage());
    }

    @Test
    void testCoursePriceValidation() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Course("Java", -5));
        assertEquals("Course price cannot be negative.", ex.getMessage());
    }

    @Test
    void testStudentNameValidation() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Student("", "Calle", "a@a.com"));
        assertEquals("Student name cannot be empty.", ex.getMessage());
    }

    @Test
    void testStudentAddressValidation() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Student("Ana", "", "a@a.com"));
        assertEquals("Address cannot be empty.", ex.getMessage());
    }

    @Test
    void testStudentEmailValidation() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Student("Ana", "Calle", "noemail"));
        assertEquals("Invalid email.", ex.getMessage());
    }

    @Test
    void testAddNegativeEarnings() {
        Course c = new Course("JS", 100);
        Exception ex = assertThrows(IllegalArgumentException.class, () -> c.addEarnings(-20));
        assertEquals("Earnings cannot be negative.", ex.getMessage());
    }
}
