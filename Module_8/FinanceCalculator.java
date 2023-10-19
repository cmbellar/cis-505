/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures: 
        Comprehensive Version (12th ed.). Pearson Education, Inc.
    Additional modifications by C. Bellar 2023
*/

public class FinanceCalculator {

    private static int MONTHS_IN_YEAR = 12; // Sets the months in a year.

    /**
     * Public void method with three arguments, which are used to calculate a future value.
     * @param monthlyPayment Double
     * @param rate Double
     * @param years int
     * @return Result of calculateFutureValue as a Double. 
     */
    static Double calculateFutureValue(Double monthlyPayment, Double rate, int years) {

        int months = MONTHS_IN_YEAR * years; // Calculate number of months.
        Double interestRate = (1 + rate / 100); // Calculate the interest rate based on supplied rate.
        Double presentValue = months * monthlyPayment; // Calculate the present value.
        Double futureValue = presentValue * (Math.pow(interestRate, months)); // Calculate the future value using the Math class.

        return futureValue; // Return futureValue.
    } // end calculateFutureValue

} // end FinanceCalculator
