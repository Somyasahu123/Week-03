package StacksAndQueues.ImplementAQueueUsingStacks;
import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public QueueUsingStacks() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    // Enqueue operation (O(1) time complexity)
    public void enqueue(int data) {
        enqueueStack.push(data);
    }

    // Dequeue operation (Amortized O(1), worst case O(n) when transferring elements)
    public int dequeue() {
        if (dequeueStack.isEmpty()) {
            if (enqueueStack.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            // Move all elements from enqueueStack to dequeueStack
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }

    // Peek operation (Returns front element without removing it)
    public int peek() {
        if (dequeueStack.isEmpty()) {
            if (enqueueStack.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }
}

public class QueueImplementation {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeue: " + queue.dequeue()); // Output: 1
        System.out.println("Peek: " + queue.peek()); // Output: 2
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 2
        System.out.println("Is Empty: " + queue.isEmpty()); // Output: false
        queue.enqueue(4);
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 3
        System.out.println("Dequeue: " + queue.dequeue()); // Output: 4
        System.out.println("Is Empty: " + queue.isEmpty()); // Output: true
    }
}
