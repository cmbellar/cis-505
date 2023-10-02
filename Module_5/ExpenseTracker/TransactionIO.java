/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

/** imports */
import java.io.File; // Import the File class.
import java.io.FileOutputStream; // Import the FileOutputStream class.
import java.io.IOException; // Import the IOException class.
import java.io.PrintWriter; // Import the PrintWriter class.
import java.util.ArrayList; // Import the ArrayList class.
import java.util.Scanner; // Import the Scanner class.

public class TransactionIO {

    private final static String FILE_NAME = "expenses.txt"; // Set the file name for expenses.
    private static File file = new File(FILE_NAME); // Initialize file using FILE_NAME.

    /**
     * Public static void method with one arguments, which is used to insert an arraylist of transactions to a file.
     * @param transactions ArrayList<Transaction> 
     * @return none.
     * @throws IOException
     */
    public static void bulkInsert (ArrayList<Transaction> transactions) 
        throws IOException {

        PrintWriter output = null; // Initialize PrintWriter for insert.

        //** If statement to determine if file exists and create it if it doesn't. */
        if (file.exists()) {
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true)); // File exists, so append content to it.
        } else {
            output = new PrintWriter(FILE_NAME); // File does not exist, so create it.
        }

        //** for loop that writes transactions to file. */
        for (Transaction tran : transactions) {
            output.print(tran.getDate() + " ");
            output.print(tran.getDescription() + " ");
            output.println(tran.getAmount());
        } // end for

        output.close(); // Close PrintWriter to prevent leaks.
    } // end bulkInsert

    /**
     * Public static ArrayList<Transaction> method that retrieves transactions from a file and returns them.
     * @return ArrayList<Transaction> of transactions from file.
     * @throws IOException
     */
    public static ArrayList<Transaction> findAll()
        throws IOException {
    
        Scanner input = new Scanner(file); // Instantiate a new scanner.
        ArrayList<Transaction> trans = new ArrayList<>(); // // Instantiate a new arraylist of transactions to hold retrieved transactions from file.

        /** Loop through file, create transaction objects from stream, and add them to created arraylist. */
        while (input.hasNext()) {
            Transaction transaction = new Transaction(input.next(), input.next(), input.nextDouble()); // Create new transaction from parsed file.
            trans.add(transaction); // Add created transaction to arraylist.
        } // end while

        input.close(); // Close scanner to prevent memory leaks.
        return trans; // Return trans object to caller.
    } // end findAll
} // end TransactionIO
