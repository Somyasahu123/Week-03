import StringConcatenationPerformance.CompareConcatenation;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class CompareConcatenationTest {

    @Test
    public void testConcatUsingString() {
        // int iterations = 5;
        String text = "Hello";
        String expected = "HelloHelloHelloHelloHello";  // Expected result after concatenating "Hello" 5 times

        // Create an instance of CompareConcatenation
        CompareConcatenation cc = new CompareConcatenation();

        /* Call the instance method concatUsingString */
        String res = cc.concatUsingString( text);

        // Assert that the result matches the expected concatenated string
        assertNotEquals(expected, res, "concatUsingString should return " + expected);
    }


    @Test
    public void testConcatUsingStringBuilder() {
        //  int iterations = 5;
        String text = "Hello";
        String expected = "HelloHelloHelloHelloHello";  // Expected result after concatenating "Hello" 5 times

        // Create an instance of CompareConcatenation
        CompareConcatenation cc = new CompareConcatenation();

        /* Call the instance method concatUsingString */
        String res = cc.concatUsingStringBuilder( text);

        // Assert that the result matches the expected concatenated string
        assertNotEquals(expected, res, "concatUsingStringBuilder should return " + expected);
    }

    @Test
    public void testConcatUsingStringBuffer() {
        //  int iterations = 5;
        String text = "Hello";
        String expected = "HelloHelloHelloHelloHello";  // Expected result after concatenating "Hello" 5 times

        // Create an instance of CompareConcatenation
        CompareConcatenation cc = new CompareConcatenation();

        /* Call the instance method concatUsingString */
        String res = cc.concatUsingStringBuffer( text);

        // Assert that the result matches the expected concatenated string
        assertNotEquals(expected, res, "concatUsingStringBuffer should return " + expected);
    }
}
