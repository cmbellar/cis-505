/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

public class Student {

    private String firstName; // Sets the firstName of the Student.
    private String lastName; // Sets the lastName of the Student.
    private String course; // Sets the course of the Student.
    private String grade; // Sets the grade of the Student.

    /** Getters */
    public String getFirstName() {
        return firstName;
    } // end getFirstName

    public String getLastName() {
        return lastName;
    } // end getLastName

    public String getCourse() {
        return course;
    } // end getCourse

    public String getGrade() {
        return grade;
    } // end getGrade
    
    /** Setters */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } // end setFirstName

    public void setLastName(String lastName) {
        this.lastName = lastName;
    } // end setLastName

    public void setCourse(String course) {
        this.course = course;
    } // end setCourse

    public void setGrade(String grade) {
        this.grade = grade;
    } // end setGrade

    /**
     * Constructor which is used to create a Student object with the default values set.
     * @return none.
     */
    Student() {
        firstName = "Jon";
        lastName = "Doe";
        course = "CIS505-T301";
        grade = "A";
    } // end Student

    /**
     * Constructor with four arguments, which are used to create a Student object.
     * @param firstName String 
     * @param lastName String
     * @param course String
     * @param grade String
     * @return none.
     */
    Student(String firstName, String lastName, String course, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.grade = grade;
    } // end Student

    /**
     * Method which is used to override the Student object's toString.
     * @return a String of Student details.
     */
    public String toString() {
        return "  First Name: " + firstName + "\n  Last Name: " + lastName + "\n  Course: " + course + "\n  Grade: " + grade;
    } // end toString

} // end Student
