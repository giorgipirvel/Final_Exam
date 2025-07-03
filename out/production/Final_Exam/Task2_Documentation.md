# University Management System (UMS) Documentation

## Project Overview

The University Management System (UMS) is a Java-based application designed to manage students and their learning courses within a university environment. The system provides functionality to store student information, manage course enrollments, and display comprehensive student data including their enrolled courses.

## System Architecture

The UMS follows object-oriented programming principles and consists of three main classes:

1. **Student** - Represents individual students in the system
2. **LearningCourse** - Represents courses that students can enroll in
3. **UMS** - Main management class that coordinates students and courses

## Package Structure

```
oop.finalexam.t2
├── Student.java
├── LearningCourse.java
└── UMS.java
```

## Class Descriptions

### 1. Student Class

The `Student` class represents a student entity in the university system with the following attributes:

- **Personal Information:**
    - `firstName` - Student's first name
    - `lastName` - Student's last name
    - `studentId` - Unique identifier for the student
    - `email` - Student's email address
    - `major` - Student's field of study

- **Course Management:**
    - `learningCourses` - List of courses the student is enrolled in

**Key Methods:**
- Constructor with parameters for initialization
- Getter and setter methods for all attributes
- `addLearningCourse()` - Adds a course to student's enrollment
- `removeLearningCourse()` - Removes a course from student's enrollment
- `toString()` - Returns formatted string representation

### 2. LearningCourse Class

The `LearningCourse` class represents a course in the university system with the following attributes:

- `title` - Name of the course
- `acceptancePrerequisites` - Prerequisites required to enroll in the course
- `majorTopics` - Main topics covered in the course

**Key Methods:**
- Default and parameterized constructors
- Getter and setter methods for all attributes
- `toString()` - Returns formatted string representation

### 3. UMS Class

The `UMS` class serves as the main management system with the following functionality:

- **Student Management:**
    - `students` - List of all students in the system
    - `addStudent()` - Adds a new student to the system
    - `removeStudent()` - Removes a student from the system
    - `findStudentById()` - Locates a student by their ID

- **Data Display:**
    - `printStudentData()` - Displays comprehensive student information including all enrolled courses
    - `createMyStudentProfile()` - Creates a student profile with actual Argus data
    - `demonstrateSystem()` - Demonstrates system functionality with sample data

## Program Flow

1. **Initialization:** UMS creates an empty list of students
2. **Student Creation:** Students are created with personal information
3. **Course Enrollment:** Learning courses are created and added to students
4. **Data Management:** Students are added to the UMS system
5. **Information Display:** Student data is printed showing all details and enrolled courses

## Key Features

### Data Integrity
- All classes use private fields with public getter/setter methods
- Lists are initialized to prevent null pointer exceptions
- Proper encapsulation ensures data security

### User-Friendly Output
- The `printStudentData()` method provides formatted output with clear headers
- Course information is numbered and well-organized
- Visual separators make the output easy to read

### Extensibility
- The system can easily accommodate additional students and courses
- New methods can be added without affecting existing functionality
- The modular design allows for easy maintenance and updates

## Sample Output

When the program runs, it displays:
- System demonstration with sample students
- Detailed student information including:
    - Personal details (ID, name, email, major)
    - Complete list of enrolled courses
    - Course details (title, prerequisites, major topics)
    - Total number of enrolled courses

## UML Class Diagram

The UML diagram has been created in Google Docs. Follow the step-by-step instructions below to create it:

### Creating UML Diagram in Google Docs - Step by Step Guide

#### Step 1: Open Google Docs
1. Go to [docs.google.com](https://docs.google.com)
2. Sign in with your Google account
3. Click "Blank document"
4. Title your document "UMS_UML_Diagram"

#### Step 2: Create Class Tables

**For Student Class:**
1. Insert → Table → 1x3 table
2. In the first row, center and bold: **Student**
3. In the second row, add all attributes:
   ```
   - firstName: String
   - lastName: String
   - studentId: String
   - email: String
   - major: String
   - learningCourses: List<LearningCourse>
   ```
4. In the third row, add all methods:
   ```
   + Student()
   + Student(String, String, String, String, String)
   + getFirstName(): String
   + setFirstName(String): void
   + getLastName(): String
   + setLastName(String): void
   + getStudentId(): String
   + setStudentId(String): void
   + getEmail(): String
   + setEmail(String): void
   + getMajor(): String
   + setMajor(String): void
   + getLearningCourses(): List<LearningCourse>
   + setLearningCourses(List<LearningCourse>): void
   + addLearningCourse(LearningCourse): void
   + removeLearningCourse(LearningCourse): void
   + toString(): String
   ```

**For LearningCourse Class:**
1. Insert → Table → 1x3 table
2. First row: **LearningCourse**
3. Second row (attributes):
   ```
   - title: String
   - acceptancePrerequisites: String
   - majorTopics: String
   ```
4. Third row (methods):
   ```
   + LearningCourse()
   + LearningCourse(String, String, String)
   + getTitle(): String
   + setTitle(String): void
   + getAcceptancePrerequisites(): String
   + setAcceptancePrerequisites(String): void
   + getMajorTopics(): String
   + setMajorTopics(String): void
   + toString(): String
   ```

**For UMS Class:**
1. Insert → Table → 1x3 table
2. First row: **UMS**
3. Second row (attributes):
   ```
   - students: List<Student>
   ```
4. Third row (methods):
   ```
   + UMS()
   + getStudents(): List<Student>
   + setStudents(List<Student>): void
   + addStudent(Student): void
   + removeStudent(Student): void
   + findStudentById(String): Student
   + printStudentData(Student): void
   + createMyStudentProfile(): Student
   + demonstrateSystem(): void
   + main(String[]): void
   ```

#### Step 3: Add Relationships with Arrows

**Connection 1: UMS → Student**
- Draw arrow from UMS table to Student table
- Add label "1..*" and "manages"
- Meaning: UMS manages multiple students

**Connection 2: Student → LearningCourse**
- Draw arrow from Student table to LearningCourse table
- Add label "1..*" and "has"
- Meaning: Each student can have multiple learning courses

#### Step 4: Format the Tables
- Right-click each table → Table properties
- Set border width to 1pt
- Set border color to black
- Center align class names and make them bold

#### Step 5: Share the Google Doc
1. Click "Share" button
2. Change access to "Anyone with the link can view"
3. Copy the sharing link

### Including Google Docs Link in Documentation

**UML Diagram Link:**
[View UML Diagram in Google Docs](https://docs.google.com/document/d/1sGH8pdL_uIHLxju2Q9P0m9Cx53r1r_XytSEIjhqoBcM/edit?usp=sharing)

*Note: Replace YOUR_GOOGLE_DOCS_LINK_HERE with the actual sharing link from your Google Docs UML diagram*

## Relationships

- **UMS ↔ Student:** One-to-Many relationship (UMS manages multiple students)
- **Student ↔ LearningCourse:** One-to-Many relationship (Student can enroll in multiple courses)

## Technical Implementation Details

### Memory Management
- Uses ArrayList for dynamic list management
- Proper initialization prevents null pointer exceptions
- Efficient list operations for adding/removing elements

### Error Handling
- Null checks in methods that search for students
- Safe list operations with proper bounds checking
- Defensive programming practices throughout

### Code Quality
- Comprehensive JavaDoc documentation for all classes and methods
- Consistent naming conventions following Java standards
- Clear separation of concerns between classes
- Proper encapsulation with private fields and public methods

## Usage Instructions

1. Compile all Java files in the `oop.finalexam.t2` package
2. Run the `UMS` class using: `java oop.finalexam.t2.UMS`
3. The program will automatically demonstrate the system functionality
4. Modify the `createMyStudentProfile()` method with actual Argus data
5. Add additional students and courses as needed

## Conclusion

The University Management System provides a robust foundation for managing student and
course data in an educational environment. The object-oriented design ensures maintainability
, extensibility, and proper data encapsulation while providing user-friendly output formatting.