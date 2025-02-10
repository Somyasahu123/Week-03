package CompareLinearBinarySearch;
import java.util.Arrays;

public class BinaryLinearSearch {
    // Linear Search: scans each element until the target is found (O(N))
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search: works on sorted arrays in O(log N)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {100,56,99,101,2,5};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        // Measure Linear Search time
        long startLinear = System.nanoTime();
        int indexLinear = linearSearch(arr, 56);
        long endLinear = System.nanoTime();
        long linearTimeNano = endLinear - startLinear;
        double linearTimeMs = linearTimeNano / 1_000_000.0; // Convert to milliseconds

        // Measure Binary Search time
        long startBinary = System.nanoTime();
        int indexBinary = binarySearch(arr, 56);
        long endBinary = System.nanoTime();
        long binaryTimeNano = endBinary - startBinary;
        double binaryTimeMs = binaryTimeNano / 1_000_000.0; // Convert to milliseconds

        System.out.println("Linear search time: " + linearTimeMs);
        System.out.println("Binary search time: " + binaryTimeMs);
    }
}






