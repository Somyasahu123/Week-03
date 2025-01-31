package StacksAndQueues.SlidingWindowMaximum;
import java.util.*;

class SlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];  // Store max values for each window
        Deque<Integer> deque = new LinkedList<>(); // Store indices, not values

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of the current window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add current index to deque
            deque.offerLast(i);

            // Store the maximum for the first valid window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}

public class MaximumElement {
    public static void main(String[] args) {

        SlidingWindow maximum = new SlidingWindow();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] maxWindow = maximum.maxSlidingWindow(nums, k);

        System.out.println("Sliding Window Maximum: " + Arrays.toString(maxWindow));
    }
}
