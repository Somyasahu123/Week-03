import RecursiveIterativeComparison.FibonacciComparison;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FibonacciComparisonTest {
    @Test
    public void testFibonacciIterative() {
        int n=15;
        int expected = 0;

        // Create an instance of CompareConcatenation
        FibonacciComparison fibonacciComparison = new FibonacciComparison();


        int res = fibonacciComparison.fibonacciIterative(n);

        // Assert that the result matches the expected concatenated string
        assertNotEquals(expected, res, "Iteratively output return " + expected);
    }
    @Test
    public void testFibonacciRecursive() {
        int n=15;
        int expected = 0;

        // Create an instance of CompareConcatenation
        FibonacciComparison fibonacciComparison = new FibonacciComparison();


        int res = fibonacciComparison.fibonacciRecursive(n);

        // Assert that the result matches the expected concatenated string
        assertNotEquals(expected, res, "Recursively output return " + expected);
    }


}
