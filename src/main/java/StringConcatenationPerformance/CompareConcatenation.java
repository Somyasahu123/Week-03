package StringConcatenationPerformance;

public class CompareConcatenation {
    // Concatenates a given text for a specified number of iterations using plain String concatenation.
    public static String concatUsingString(String text) {
        String result = "";
        for (int i = 0; i <1000000; i++) {
            result.concat(text);
        }

        return result;
    }

    // Concatenates a given text for a specified number of iterations using StringBuilder.
    public static String concatUsingStringBuilder( String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append(text);
        }
        return sb.toString();
    }

    // Concatenates a given text for a specified number of iterations using StringBuffer.
    public static String concatUsingStringBuffer(String text) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            sb.append(text);
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        // Define the size of the dataset.

        String text = "Hello World";

        long start = System.nanoTime();
        concatUsingString(text);
        long end = System.nanoTime();
        double durationString = (end - start);


        long startM = System.nanoTime();
        concatUsingStringBuilder(text);
        long endM = System.nanoTime();
        double durationStringBuilder = (endM - startM) ;


        long startQ = System.nanoTime();
        concatUsingStringBuffer(text);
        long endQ = System.nanoTime();
        double durationStringBuffer = (endQ - startQ);

        // Output the performance results.
        System.out.println("Sorting Large Data Comparison:");
        System.out.println("String time: " + durationString + " ms");
        System.out.println("String Builder time:  " + durationStringBuilder + " ms");
        System.out.println("String Buffer time:  " + durationStringBuffer + " ms");
    }
}
