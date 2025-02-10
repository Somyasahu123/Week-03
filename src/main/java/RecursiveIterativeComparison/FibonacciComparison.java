package RecursiveIterativeComparison;

import java.util.Scanner;

public class FibonacciComparison {
    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        long start = System.nanoTime();
        int index = fibonacciIterative(n);
        long end = System.nanoTime();
        long TimeNano = end - start;



        long startB = System.nanoTime();
        int indexB = fibonacciRecursive(n);
        long endB = System.nanoTime();
        long binaryTimeNano = endB - startB;


        System.out.println("Iterative time: " +  TimeNano + " nanoseconds");
        System.out.println("Recursive1 time: " + binaryTimeNano + " nanoseconds");
    }
}
