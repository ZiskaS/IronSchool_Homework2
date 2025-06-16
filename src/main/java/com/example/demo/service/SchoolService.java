package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class SchoolService {
    // Listas que actúan como "base de datos en memoria"
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();

    // Métodos para agregar entidades
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    // Obtener listas completas
    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    // Buscar por ID
    public Teacher getTeacherById(String id) {
        return teachers.stream()
                .filter(t -> t.getTeacherId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Course getCourseById(String id) {
        return courses.stream()
                .filter(c -> c.getCourseId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Student getStudentById(String id) {
        return students.stream()
                .filter(s -> s.getStudentId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Asignar profesor a curso
    public void assignTeacherToCourse(String teacherId, String courseId) {
        Teacher teacher = getTeacherById(teacherId);
        Course course = getCourseById(courseId);
        if (teacher != null && course != null) {
            course.setTeacher(teacher);
        } else {
            throw new IllegalArgumentException("Invalid teacher or course ID.");
        }
    }

    // Inscribir estudiante en curso
    public void enrollStudentInCourse(String studentId, String courseId) {
        Student student = getStudentById(studentId);
        Course course = getCourseById(courseId);
        if (student != null && course != null) {
            student.setCourse(course);
            course.addEarnings(course.getPrice());
        } else {
            throw new IllegalArgumentException("Invalid student or course ID.");
        }
    }

    // Calcular beneficio total
    public double getProfit() {
        double totalEarned = courses.stream().mapToDouble(Course::getMoneyEarned).sum();
        double totalSalaries = teachers.stream().mapToDouble(Teacher::getSalary).sum();
        return totalEarned - totalSalaries;
    }
}
