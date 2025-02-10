package CompareDifferentDataStructure;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class SearchinginDataStructure {

    public static void main(String[] args) {
        // Define dataset size.
        int n = 100_000; // Use a large number to see performance differences.
        int[] arr = new int[n];
        Random rand = new Random();

        // Fill the array with random integers.
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1_000_000);
        }

        // Choose a target element from the array (for a fair comparison).
        int target = arr[n / 2]; // Picking an element from the middle.

        // -------------------------------
        // Array: Linear Search (O(N))
        // -------------------------------
        long startTime = System.nanoTime();
        boolean foundInArray = false;
        for (int value : arr) {
            if (value == target) {
                foundInArray = true;
                break;
            }
        }
        long endTime = System.nanoTime();
        double arraySearchTime = (endTime - startTime) / 1_000_000.0; // in milliseconds

        // -------------------------------
        // HashSet: O(1) on average
        // -------------------------------
        HashSet<Integer> hashSet = new HashSet<>();
        for (int value : arr) {
            hashSet.add(value);
        }
        startTime = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(target);
        endTime = System.nanoTime();
        double hashSetSearchTime = (endTime - startTime) / 1_000_000.0; // in milliseconds

        // -------------------------------
        // TreeSet: O(log N)
        // -------------------------------
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int value : arr) {
            treeSet.add(value);
        }
        startTime = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(target);
        endTime = System.nanoTime();
        double treeSetSearchTime = (endTime - startTime) / 1_000_000.0; // in milliseconds

        // -------------------------------
        // Print the results
        // -------------------------------
        System.out.println("Search Comparison for target " + target + ":");
        System.out.println("Array (Linear Search) found target: " + foundInArray + " in " + arraySearchTime + " ms");
        System.out.println("HashSet found target: " + foundInHashSet + " in " + hashSetSearchTime + " ms");
        System.out.println("TreeSet found target: " + foundInTreeSet + " in " + treeSetSearchTime + " ms");
    }
}
