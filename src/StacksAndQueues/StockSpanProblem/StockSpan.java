package StacksAndQueues.StockSpanProblem;
import java.util.Stack;

class Stock {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];  // Array to store span values
        Stack<Integer> stack = new Stack<>(); // Stack stores indices

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and price at stack top is <= current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, all previous elements are smaller, so span = i+1
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push current index onto stack
            stack.push(i);
        }
        return span;
    }
}

public class StockSpan {
    public static void main(String[] args) {

        Stock stock = new Stock();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = stock.calculateSpan(prices);

        System.out.println("Stock Prices: ");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println("\nStock Span: ");
        for (int s : spans) {
            System.out.print(s + " ");
        }
    }
}
