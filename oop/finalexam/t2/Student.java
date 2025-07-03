package oop.finalexam.t2;

import java.util.ArrayList;
import java.util.List;

/**
 * Student class represents a student in the university management system.
 * Each student has personal information and a list of learning courses.
 *
 * @author Your Name
 * @version 1.0
 */
public class Student {

    /**
     * The first name of the student
     */
    private String firstName;

    /**
     * The last name of the student
     */
    private String lastName;

    /**
     * The student ID number
     */
    private String studentId;

    /**
     * The email address of the student
     */
    private String email;

    /**
     * The major/field of study of the student
     */
    private String major;

    /**
     * The list of learning courses the student is enrolled in
     */
    private List<LearningCourse> learningCourses;

    /**
     * Default constructor for Student
     */
    public Student() {
        this.learningCourses = new ArrayList<>();
    }

    /**
     * Constructor with parameters for Student
     *
     * @param firstName The first name of the student
     * @param lastName The last name of the student
     * @param studentId The student ID
     * @param email The email address
     * @param major The major/field of study
     */
    public Student(String firstName, String lastName, String studentId, String email, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.email = email;
        this.major = major;
        this.learningCourses = new ArrayList<>();
    }

    /**
     * Gets the first name of the student
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the student
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the student ID
     *
     * @return the student ID
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Sets the student ID
     *
     * @param studentId the student ID to set
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets the email address of the student
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the student
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the major/field of study of the student
     *
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * Sets the major/field of study of the student
     *
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Gets the list of learning courses for the student
     *
     * @return the list of learning courses
     */
    public List<LearningCourse> getLearningCourses() {
        return learningCourses;
    }

    /**
     * Sets the list of learning courses for the student
     *
     * @param learningCourses the list of learning courses to set
     */
    public void setLearningCourses(List<LearningCourse> learningCourses) {
        this.learningCourses = learningCourses;
    }

    /**
     * Adds a learning course to the student's course list
     *
     * @param course the learning course to add
     */
    public void addLearningCourse(LearningCourse course) {
        this.learningCourses.add(course);
    }

    /**
     * Removes a learning course from the student's course list
     *
     * @param course the learning course to remove
     */
    public void removeLearningCourse(LearningCourse course) {
        this.learningCourses.remove(course);
    }

    /**
     * Returns a string representation of the Student object
     *
     * @return formatted string with student details
     */
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", learningCourses=" + learningCourses +
                '}';
    }
}