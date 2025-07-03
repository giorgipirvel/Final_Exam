package oop.finalexam.t2;

import java.util.ArrayList;
import java.util.List;

/**
 * UMS (University Management System) class manages students and their learning courses.
 * This class provides functionality to add students, manage their courses, and print student data.
 *
 * @author Your Name
 * @version 1.0
 */
public class UMS {

    /**
     * The list of students in the university management system
     */
    private List<Student> students;

    /**
     * Constructor for UMS - initializes the student list
     */
    public UMS() {
        this.students = new ArrayList<>();
    }

    /**
     * Gets the list of students in the system
     *
     * @return the list of students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Sets the list of students in the system
     *
     * @param students the list of students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Adds a student to the university management system
     *
     * @param student the student to add
     */
    public void addStudent(Student student) {
        this.students.add(student);
    }

    /**
     * Removes a student from the university management system
     *
     * @param student the student to remove
     */
    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    /**
     * Finds a student by their student ID
     *
     * @param studentId the ID of the student to find
     * @return the student with the given ID, or null if not found
     */
    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Prints detailed information about a student including all their learning courses.
     * The output clearly shows which learning courses belong to which student.
     *
     * @param student the student whose data should be printed
     */
    public void printStudentData(Student student) {
        System.out.println("==========================================");
        System.out.println("           STUDENT INFORMATION");
        System.out.println("==========================================");
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Major: " + student.getMajor());
        System.out.println("==========================================");

        List<LearningCourse> courses = student.getLearningCourses();
        if (courses.isEmpty()) {
            System.out.println("No learning courses enrolled.");
        } else {
            System.out.println("LEARNING COURSES FOR " + student.getFirstName().toUpperCase() + " " +
                    student.getLastName().toUpperCase() + ":");
            System.out.println("==========================================");

            for (int i = 0; i < courses.size(); i++) {
                LearningCourse course = courses.get(i);
                System.out.println("Course #" + (i + 1) + ":");
                System.out.println("  Title: " + course.getTitle());
                System.out.println("  Acceptance Prerequisites: " + course.getAcceptancePrerequisites());
                System.out.println("  Major Topics: " + course.getMajorTopics());
                System.out.println("------------------------------------------");
            }

            System.out.println("Total Courses Enrolled: " + courses.size());
        }
        System.out.println("==========================================");
    }

    /**
     * Creates and returns a student with your personal data and courses from Argus.
     * NOTE: Replace this with your actual data from Argus system.
     *
     * @return Student object with your personal information and Argus courses
     */
    public Student createMyStudentProfile() {
        // TODO: Replace with your actual data from Argus
        Student myProfile = new Student(
                "Giorgi",      // Replace with your first name
                "Pirveli",       // Replace with your last name
                "2343222112",    // Replace with your student ID
                "giorgi.pirveli@iliauni.edu.ge", // Replace with your email
                "Computer Science"    // Replace with your major
        );

        // Your actual courses from Argus
        LearningCourse oopCourse = new LearningCourse(
                "Object Oriented Programming (ENG)",
                "CS50 Introduction to Programming",
                "Java syntax and data structures; Procedural programming; Classes; Encapsulation, polymorphism, inheritance; Packages; Working with the network; Work with files; Working with text data; Work with the terminal."
        );

        LearningCourse computerOrgCourse = new LearningCourse(
                "Computer Organization (ENG)",
                "CS50 Introduction to Programming",
                "Representing and manipulating information; Machine-level representations of programs; Optimizing program performance; The memory hierarchy."
        );

        LearningCourse mathFoundationCourse = new LearningCourse(
                "Mathematical Foundation of Computing (ENG)",
                "MATH 150 Calculus I; CS50 Introduction to Programming",
                "Representing and manipulating information; Machine-level representations of programs; Optimizing program performance; The memory hierarchy."
        );

        LearningCourse calculusIICourse = new LearningCourse(
                "Calculus II (ENG)",
                "MATH150 Calculus I",
                "Antiderivatives; Definite integrals; Techniques and applications of integration; Improper integrals; Infinite series."
        );

        LearningCourse englishCourse = new LearningCourse(
                "English Language Course C1-2 (ENG)",
                "English Language Course (C1-1)",
                "Culture; Interpretation; Persuasion; Connection; Technology; Independence"
        );

        myProfile.addLearningCourse(oopCourse);
        myProfile.addLearningCourse(computerOrgCourse);
        myProfile.addLearningCourse(mathFoundationCourse);
        myProfile.addLearningCourse(calculusIICourse);
        myProfile.addLearningCourse(englishCourse);

        return myProfile;
    }

    /**
     * Demonstrates the UMS functionality with sample data
     */
    public void demonstrateSystem() {
        System.out.println("=== UNIVERSITY MANAGEMENT SYSTEM DEMO ===");

        // Create sample students
        Student student1 = new Student("John", "Doe", "STU001", "john.doe@university.edu", "Computer Science");
        Student student2 = new Student("Jane", "Smith", "STU002", "jane.smith@university.edu", "Information Technology");

        // Add sample courses to students
        LearningCourse course1 = new LearningCourse("Java Programming", "Basic Programming", "OOP, Collections, Exception Handling");
        LearningCourse course2 = new LearningCourse("Web Development", "HTML/CSS Knowledge", "JavaScript, React, Node.js");

        student1.addLearningCourse(course1);
        student1.addLearningCourse(course2);

        student2.addLearningCourse(course1);

        // Add students to UMS
        addStudent(student1);
        addStudent(student2);

        // Print student data
        printStudentData(student1);
        printStudentData(student2);

        // Create and print your profile
        System.out.println("\n=== MY STUDENT PROFILE ===");
        Student myProfile = createMyStudentProfile();
        addStudent(myProfile);
        printStudentData(myProfile);
    }

    /**
     * Main method to run the University Management System
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        UMS universitySystem = new UMS();
        universitySystem.demonstrateSystem();
    }
}