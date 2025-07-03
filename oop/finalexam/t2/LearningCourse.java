package oop.finalexam.t2;

/**
 * LearningCourse class represents a course in the university system.
 * Each course has a title, acceptance prerequisites, and major topics.
 *
 * @author Your Name
 * @version 1.0
 */
public class LearningCourse {

    /**
     * The title of the learning course
     */
    private String title;

    /**
     * The acceptance prerequisites for the course
     */
    private String acceptancePrerequisites;

    /**
     * The major topics covered in the course
     */
    private String majorTopics;

    /**
     * Default constructor for LearningCourse
     */
    public LearningCourse() {
    }

    /**
     * Constructor with parameters for LearningCourse
     *
     * @param title The title of the course
     * @param acceptancePrerequisites The prerequisites for the course
     * @param majorTopics The major topics of the course
     */
    public LearningCourse(String title, String acceptancePrerequisites, String majorTopics) {
        this.title = title;
        this.acceptancePrerequisites = acceptancePrerequisites;
        this.majorTopics = majorTopics;
    }

    /**
     * Gets the title of the learning course
     *
     * @return the title of the course
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the learning course
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the acceptance prerequisites of the learning course
     *
     * @return the acceptance prerequisites
     */
    public String getAcceptancePrerequisites() {
        return acceptancePrerequisites;
    }

    /**
     * Sets the acceptance prerequisites of the learning course
     *
     * @param acceptancePrerequisites the acceptance prerequisites to set
     */
    public void setAcceptancePrerequisites(String acceptancePrerequisites) {
        this.acceptancePrerequisites = acceptancePrerequisites;
    }

    /**
     * Gets the major topics of the learning course
     *
     * @return the major topics
     */
    public String getMajorTopics() {
        return majorTopics;
    }

    /**
     * Sets the major topics of the learning course
     *
     * @param majorTopics the major topics to set
     */
    public void setMajorTopics(String majorTopics) {
        this.majorTopics = majorTopics;
    }

    /**
     * Returns a string representation of the LearningCourse object
     *
     * @return formatted string with course details
     */
    @Override
    public String toString() {
        return "LearningCourse{" +
                "title='" + title + '\'' +
                ", acceptancePrerequisites='" + acceptancePrerequisites + '\'' +
                ", majorTopics='" + majorTopics + '\'' +
                '}';
    }
}