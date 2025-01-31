package StacksAndQueues.SortAStackUsingRecursion;
import java.util.Stack;

class StackSort {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Pop the top element
            int temp = stack.pop();

            // Recursively sort the remaining stack
            sortStack(stack);

            // Insert the popped element at the correct position
            insertSorted(stack, temp);
        }
    }

    // Function to insert an element in a sorted manner
    private static void insertSorted(Stack<Integer> stack, int element) {
        // Base condition: If stack is empty or top is smaller, push element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Pop the top element and insert recursively
        int temp = stack.pop();
        insertSorted(stack, element);

        // Push the popped element back
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(3);
        stack.push(7);
        stack.push(2);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
