/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

import java.io.File; // Import the File class.
import java.io.FileOutputStream; // Import the FileOutputStream class.
import java.io.IOException; // Import the IOException class.
import java.io.PrintWriter; // Import the PrintWriter class.
import java.util.ArrayList; // Import the ArrayList class.
import java.util.Scanner; // Import the Scanner class.

public class StudentIO {

    /**
     * Set the csv filename for IO operations.
     */
    private final static String FILE_NAME = "./GradeBookApp/grades.csv"; // Set the file name for grades.
    private static File file = new File(FILE_NAME); // Initialize file using FILE_NAME.

    /**
     * Public static void method with one argument, which is used to insert student data to a file.
     * @param student Student 
     * @return none.
     * @throws IOException
     */
    public static void insertStudent (Student student) 
        throws IOException {
        
        PrintWriter output = null; // Initialize PrintWriter for insert.
        
        //** If statement to determine if file exists and create it if it doesn't. */
        if (file.exists()) {
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true)); // File exists, so append content to it.
        } else {
            output = new PrintWriter(FILE_NAME); // File does not exist, so create it.
        } // end if

        output.println(student.getFirstName() + "," + student.getLastName() + "," + student.getCourse() + "," + student.getGrade()); // Write values to grades.csv file.
        output.close(); // Close PrintWriter to prevent leaks.
    } // end insertStudent

    /**
     * Public static ArrayList<Student> method that retrieves students from a file and returns them.
     * @return ArrayList<Student> of students from the file.
     * @throws IOException
     */
    public static ArrayList<Student> findAll()
        throws IOException {
        
        Scanner input = new Scanner(file); // Instantiate a new scanner.
        ArrayList<Student> students = new ArrayList<>(); // // Instantiate a new arraylist of students to hold retrieved students from file.
        
        /** Loop through file, create student objects from stream, and add them to created arraylist. */
        while (input.hasNextLine()) {
            String[] studentsArray = input.nextLine().split(","); // Split input on comma and store results in a String array.
            Student student = new Student(studentsArray[0], studentsArray[1], studentsArray[2], studentsArray[3]); // Create new Student from parsed file.
            students.add(student); // Add created student to arraylist.
        } // end while

        input.close(); // Close scanner to prevent memory leaks.
        return students; // return Student students to caller.
    } // end findAll

} // end StudentIO
