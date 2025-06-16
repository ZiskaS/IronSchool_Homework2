package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SchoolServiceTest {

    private SchoolService service;
    private Teacher teacher;
    private Course course;
    private Student student;

    @BeforeEach
    void setUp() {
        service = new SchoolService();
        teacher = new Teacher("Luis", 1500.0);
        course = new Course("Java", 500.0);
        student = new Student("Arni", "Calle 1", "arni@email.com");

        service.addTeacher(teacher);
        service.addCourse(course);
        service.addStudent(student);
    }

    @Test
    void testAssignTeacherToCourse() {
        service.assignTeacherToCourse(teacher.getTeacherId(), course.getCourseId());
        assertEquals(teacher, course.getTeacher());
    }

    @Test
    void testEnrollStudentInCourse() {
        service.enrollStudentInCourse(student.getStudentId(), course.getCourseId());
        assertEquals(course, student.getCourse());
        assertEquals(500.0, course.getMoneyEarned());
    }

    @Test
    void testEnrollStudentInvalidId() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                service.enrollStudentInCourse("INVALID", course.getCourseId()));
        assertEquals("Invalid student or course ID.", ex.getMessage());
    }

    @Test
    void testAssignTeacherInvalidId() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                service.assignTeacherToCourse("T999", course.getCourseId()));
        assertEquals("Invalid teacher or course ID.", ex.getMessage());
    }

    @Test
    void testGetProfitCalculation() {
        // No ganancia ni gasto
        assertEquals(-1500.0, service.getProfit());

        // Ingresos después de inscripción
        service.enrollStudentInCourse(student.getStudentId(), course.getCourseId());
        assertEquals(-1000.0, service.getProfit()); // 500 - 1500
    }
}
