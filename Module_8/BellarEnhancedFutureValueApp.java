/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.time.LocalDateTime; // Import the LocalDateTime class.
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class.
import javafx.application.Application; // Import the Application class.
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos; // Import the HPos class.
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
import javafx.scene.paint.Color; // Import the Color class.
import javafx.stage.Stage; // Import the Stage class.

public class BellarEnhancedFutureValueApp extends Application {

    /** Create the private labels. */
    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label lblYears = new Label("Years:");
    private Label lblFutureValueDate = new Label("");

    /** Create the private TextFields. */
    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();

    /** Create the private TextArea. */
    private TextArea txtResults = new TextArea();

    /** Create the private Buttons. */
    private Button btnCalculate = new Button("Calculate");
    private Button btnClear = new Button("Clear");

    /** 
     * Create the private ComboBox of type Integer and pre-populate years. 
     * I feel 10 years is sufficient to test the application.
     */
    private ComboBox<Integer> cbYears = new ComboBox<Integer>();
    ObservableList<Integer> cbList = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

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

        pane.add(lblMonthlyPayment, 0, 0); // Add lblMonthlyPayment to GridPane pane.
        pane.add(txtMonthlyPayment, 1, 0); // Add txtMonthlyPayment to GridPane pane.
        pane.add(lblInterestRate, 0, 1); // Add lblInterestRate to GridPane pane.
        pane.add(txtInterestRate, 1, 1); // Add txtInterestRate to GridPane pane.

        lblInterestRateFormat.setTextFill(Color.RED); // Set lblInterestRateFormat to the color RED.
        pane.add(lblInterestRateFormat, 1, 2); // Add lblInterestRateFormat to GridPane pane.
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT); // Set the lblInterestRateFormat horizontal position to RIGHT.

        pane.add(lblYears, 0, 3); // Add lblYears to GridPane pane.

        cbYears.setItems(cbList); // Add Integer ObservableList to cbYears ComboBox.
        cbYears.setMaxWidth(200); // Set minimum width of cbYears so it matches the TextBox.
        pane.add(cbYears, 1, 3); // Add cbYears to GridPane pane.

        HBox actionBtnContainer = new HBox(); // Create HBox to be container of buttons.
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30) ); // Set HBox padding.
        actionBtnContainer.setSpacing(10); // Set HBox spacing.
        actionBtnContainer.getChildren().add(btnClear); // Add btnClear to actionBtnContainer HBox.
        actionBtnContainer.getChildren().add(btnCalculate); // Add btnCalculate to actionBtnContainer HBox.
        pane.add(actionBtnContainer, 1, 4); // Add actionBtnContainer to GridPane pane.

        pane.add(lblFutureValueDate, 0, 5); // Add lblFutureValueDate to GridPane pane.
        pane.add(txtResults, 0, 6, 2, 2); // Add txtResults to GridPane pane and span both columns.

        btnClear.setOnAction(e -> clearFormFields()); // Set Clear button to call clearFormFields on click. 
        btnCalculate.setOnAction(e -> calculateResults()); // Set Calculate button to call calculateResults on click. 

        Scene scene = new Scene(pane);  // Create a scene object to display GridPane pane.
      
        primaryStage.setTitle("Bellar Future Value App"); //Set the title for the stage.
         
        primaryStage.setScene(scene); // Add scene object to stage.
         
        primaryStage.show(); //Display the contents of the primaryStage object.
    } // end start

    /**
     * Private void method no arguments which clears the form fields that can changed by the user.
     * @return none. 
     */
    private void clearFormFields() {
        /** Clear all of the form fields that can changed by the user. */
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        txtResults.setText("");
        lblFutureValueDate.setText("");
        cbYears.setValue(0);
    } // end clearFormFields

    /**
     * Private void method no arguments which calculates the future value and displays it to the user.
     * @return none. 
     */
    private void calculateResults() {
        lblFutureValueDate.setText("Calculation as of " + todaysDate()); // Set lblFutureValueDate text to message with current date.

        /** 
         * Set txtResults text using calculateFutureValue from FinanceCalculator.
         * Formatted the future value to $%,6.2f using String.format.
         */
        txtResults.setText(String.format("The future value is $%,6.2f", FinanceCalculator.calculateFutureValue(
            Double.parseDouble(txtMonthlyPayment.getText()), 
            Double.parseDouble(txtInterestRate.getText()), 
            cbYears.getValue())));
    } // calculateResults

    /**
     * Private String method no arguments which calculates todays date and formats it.
     * @return The current date formatted as (MM/dd/yyyy) as a String. 
     */
    private String todaysDate() {
        LocalDateTime currentDate = LocalDateTime.now(); // Set current date to be formatted as a LocalDateTime object.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Set desired format as a DateTimeFormatter object.
        return currentDate.format(formatter); // Set formatted LocalDateTime object as date String.
    } // end todaysDate

    /**
     * A static void method which is used to test the start method since vscode isn't launching the stage
     * without it.
     * @return none.
     */
    public static void main(String[] args) {
        launch(args);
    } // end main
} // end BellarFutureValueApp
