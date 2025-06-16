package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.service.SchoolService;

import java.util.Scanner;

public class MenuApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SchoolService service = new SchoolService();

        System.out.print("Enter school name: ");
        String schoolName = scanner.nextLine();
        System.out.println("Welcome to " + schoolName + " School System!\n");

        // Crear profesores
        System.out.print("How many teachers? ");
        int tCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < tCount; i++) {
            System.out.println("Teacher #" + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());
            service.addTeacher(new Teacher(name, salary));
        }

        // Crear cursos
        System.out.print("How many courses? ");
        int cCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cCount; i++) {
            System.out.println("Course #" + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            service.addCourse(new Course(name, price));
        }

        // Crear estudiantes
        System.out.print("How many students? ");
        int sCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < sCount; i++) {
            System.out.println("Student #" + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            service.addStudent(new Student(name, address, email));
        }

        // Bucle de comandos
        System.out.println("\nEnter a command (type EXIT to quit):");
        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("EXIT")) break;

            try {
                String[] parts = line.split(" ");
                String command = parts[0];

                switch (command) {
                    case "ENROLL" -> service.enrollStudentInCourse(parts[1], parts[2]);
                    case "ASSIGN" -> service.assignTeacherToCourse(parts[1], parts[2]);
                    case "SHOW" -> {
                        switch (parts[1]) {
                            case "COURSES" -> service.getCourses().forEach(System.out::println);
                            case "STUDENTS" -> {
                                if (parts.length == 3) {
                                    String courseId = parts[2];
                                    service.getStudents().stream()
                                            .filter(s -> s.getCourse() != null && s.getCourse().getCourseId().equals(courseId))
                                            .forEach(System.out::println);
                                } else {
                                    service.getStudents().forEach(System.out::println);
                                }
                            }
                            case "TEACHERS" -> service.getTeachers().forEach(System.out::println);
                            case "PROFIT" -> System.out.println("Profit: " + service.getProfit());
                            case "MONEY" -> {
                                if (parts[2].equals("EARNED")) {
                                    double total = service.getCourses().stream().mapToDouble(Course::getMoneyEarned).sum();
                                    System.out.println("Total Money Earned: " + total);
                                } else if (parts[2].equals("SPENT")) {
                                    double total = service.getTeachers().stream().mapToDouble(Teacher::getSalary).sum();
                                    System.out.println("Total Money Spent: " + total);
                                }
                            }
                        }
                    }
                    case "LOOKUP" -> {
                        switch (parts[1]) {
                            case "COURSE" -> {
                                Course c = service.getCourseById(parts[2]);
                                System.out.println(c != null ? c : "Course not found.");
                            }
                            case "STUDENT" -> {
                                Student s = service.getStudentById(parts[2]);
                                System.out.println(s != null ? s : "Student not found.");
                            }
                            case "TEACHER" -> {
                                Teacher t = service.getTeacherById(parts[2]);
                                System.out.println(t != null ? t : "Teacher not found.");
                            }
                        }
                    }
                    default -> System.out.println("Invalid command.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Exiting...");
        scanner.close();
    }
}
