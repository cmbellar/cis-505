/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.io.IOException; // Import the IOException class.
import java.util.ArrayList; // Import the ArrayList class.

import javafx.application.Application; // Import the Application class.
import javafx.collections.FXCollections; // Import the FXCollections class.
import javafx.collections.ObservableList; // Import the ObservableList class.
import javafx.geometry.Insets; // Import the Insets class.
import javafx.geometry.Pos; // Import the Pos class.
import javafx.scene.Scene; // Import the Scene class.
import javafx.scene.control.Button; // Import the Button class.
import javafx.scene.control.ComboBox; // Import the ComboBox class.
import javafx.scene.control.Label; // Import the Label class.
import javafx.scene.control.TextArea; // Import the TextArea class.
import javafx.scene.control.TextField; // Import the TextField class.
import javafx.scene.layout.GridPane; // Import the GridPane class.
import javafx.scene.layout.HBox; // Import the HBox class.
import javafx.stage.Stage; // Import the Stage class.

public class BellarGradeBookApp extends Application {

    /** Create the private labels. */
    private Label lblFirstName = new Label("First Name:");
    private Label lblLastName = new Label("Last Name:");
    private Label lblCourse = new Label("Course:");
    private Label lblGrade = new Label("Grade:");
    private Label lblResults = new Label("");

    /** Create the private TextFields. */
    private TextField txtFirstName = new TextField();
    private TextField txtLastName = new TextField();
    private TextField txtCourse = new TextField();

    /** Create the private TextArea. */
    private TextArea txtResults = new TextArea();

    /** Create the private Buttons. */
    private Button btnClear = new Button("Clear");
    private Button btnViewGrades = new Button("View Grades");
    private Button btnSave = new Button("Save");

    /** 
     * Create the private ComboBox of type cbGrades and pre-populate grades. 
     */
    private ComboBox<String> cbGrades = new ComboBox<String>();
    ObservableList<String> cbList = FXCollections.observableArrayList("A", "B", "C", "D", "F");

    /**
     * Public void method with one argument which is used to generate a GUI stage to display.
     * Overrides start method in javafx.application.Application.
     * @param primaryStage Stage
     * @return none.
     */
    @Override
    public void start(Stage primaryStage) {
        
        GridPane pane = new GridPane(); // Create GridPane to be container of content.
        pane.setAlignment(Pos.CENTER); // Set GridPane alignment to CENTER.
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5)); // Set GridPane padding.
        pane.setVgap(5); // Set GridPane vertical gap.
        pane.setHgap(5); // Set GridPane horizontal gap.

        pane.add(lblFirstName, 0, 0); // Add lblFirstName to GridPane pane.
        pane.add(txtFirstName, 1, 0); // Add txtFirstName to GridPane pane.
        pane.add(lblLastName, 0, 1); // Add lblLastName to GridPane pane.
        pane.add(txtLastName, 1, 1); // Add txtLastName to GridPane pane.
        pane.add(lblCourse, 0, 2); // Add lblCourse to GridPane pane.
        pane.add(txtCourse, 1, 2); // Add txtCourse to GridPane pane.

        pane.add(lblGrade, 0, 3); // Add lblGrade to GridPane pane.

        cbGrades.setItems(cbList); // Add String ObservableList to cbGrades ComboBox.
        cbGrades.setMaxWidth(200); // Set minimum width of cbGrades.
        pane.add(cbGrades, 1, 3); // Add cbGrades to GridPane pane.

        HBox actionBtnContainer = new HBox(); // Create HBox to be container of buttons.
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30) ); // Set HBox padding.
        actionBtnContainer.setSpacing(10); // Set HBox spacing.
        actionBtnContainer.getChildren().add(btnClear); // Add btnClear to actionBtnContainer HBox.
        actionBtnContainer.getChildren().add(btnViewGrades); // Add btnViewGrades to actionBtnContainer HBox.
        actionBtnContainer.getChildren().add(btnSave); // Add btnSave to actionBtnContainer HBox.
        pane.add(actionBtnContainer, 1, 4); // Add actionBtnContainer to GridPane pane.

        pane.add(lblResults, 0, 5); // Add lblResults to GridPane pane.
        pane.add(txtResults, 0, 6, 2, 2); // Add txtResults to GridPane pane and span both columns.

        btnClear.setOnAction(e -> clearFormFields()); // Set Clear button to call clearFormFields on click. 
        btnViewGrades.setOnAction(e -> {
            try {
                viewGrades();
            } catch (IOException ex) {
                ex.printStackTrace(); // IOException occurred, so print the stack trace. 
            }
        }); // Set View Grades button to call viewGrades on click.
        btnSave.setOnAction(e -> {
            try {
                saveStudent();
            } catch (IOException ex) {
                ex.printStackTrace(); // IOException occurred, so print the stack trace. 
            }
        }); // Set Save button to call saveStudent on click.

        Scene scene = new Scene(pane);  // Create a scene object to display GridPane pane.
      
        primaryStage.setTitle("Bellar Grade Book App"); //Set the title for the stage.
         
        primaryStage.setScene(scene); // Add scene object to stage.
         
        primaryStage.show(); //Display the contents of the primaryStage object.
    } // end start

    /**
     * Private void method with no arguments which clears the form fields that can changed by the user.
     * @return none. 
     */
    private void clearFormFields() {
        /** Clear all of the form fields that can changed by the user. */
        txtFirstName.setText("");
        txtLastName.setText("");
        txtCourse.setText("");
        cbGrades.setValue("");
        txtResults.setText("");
    } // end clearFormFields

    /**
     * Private void method with no arguments which formats displays content from grades.csv file.
     * @throws IOException
     * @return none. 
     */
    private void viewGrades() 
        throws IOException {

        txtResults.setText("  Student Grades: \n\n"); // Set header in txtResults.
        ArrayList<Student> students = StudentIO.findAll(); // Get a list of students from grades.csv.
        
        /** Loop through Student objects and add them to txtResults. */
        for (Student student : students) {
            txtResults.appendText(student.toString() + "\n\n"); // Append student to txtResults.
        } // end for
    } // end viewGrades

    /**
     * Private void method with no arguments which inserts student grades information in the grades.csv file.
     * @throws IOException
     * @return none. 
     */
    private void saveStudent()
        throws IOException {
        
         //** If statement to determine if all fields have values and process it only if all fields do. */
        if (txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() || txtCourse.getText().isEmpty() || cbGrades.getSelectionModel().isEmpty()) {
            txtResults.setText("  ERROR: One or more fields do not contain a value. Please add missing values and retry."); // Notify user of error.
        } else {
            Student student = new Student(txtFirstName.getText(), txtLastName.getText(), txtCourse.getText() , cbGrades.getValue()); // Create Student object with user provided values.
            StudentIO.insertStudent(student); // Call insertStudent from StudentIO to insert student.
            txtResults.setText("  --Details--\n" + student.toString() + "\n\n  Save Successful!"); // Display details to user so they know insert was successful.
        } // end if
    } // end saveStudent

    /**
     * A static void method which is used to test the start method since vscode isn't launching the stage
     * without it.
     * @return none.
     */
    public static void main(String[] args) {
        launch(args);
    } // end main
} // end BellarGradeBookApp
