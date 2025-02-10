package SortingLargeDataEfficiently;

import java.util.Arrays;
public class CompareSorting {

    // Bubble Sort (O(N²)): Repeatedly swaps adjacent elements if they are in the wrong order.
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Perform n-1 passes over the array.
        for (int i = 0; i < n - 1; i++) {
            // Compare adjacent elements and swap if necessary.
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort (O(N log N)): Divide and conquer algorithm that is stable.
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return; // Base case: array is already sorted.
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Recursively sort the left and right halves.
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves.
        merge(arr, left, right);
    }

    // Helper method to merge two sorted arrays.
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        // Merge elements into arr[] in sorted order.
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        // Copy any remaining elements from left[]
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        // Copy any remaining elements from right[]
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Quick Sort (O(N log N) on average): Partition-based, fast but unstable.
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index.
            int pivotIndex = partition(arr, low, high);
            // Recursively sort elements before and after partition.
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Helper method to partition the array for Quick Sort.
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choose the last element as the pivot.
        int i = low - 1;        // Index of smaller element.
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Place the pivot element in its correct position.
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        // Define the size of the dataset.

        int[] arr = {10,20,5,2,50};



        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        // Measure and print the time taken by Bubble Sort.
        long startBubble = System.nanoTime();
        bubbleSort(arr);
        long endBubble = System.nanoTime();
        double durationBubble = (endBubble - startBubble) / 1_000_000.0;

        // Measure and print the time taken by Merge Sort.
        long startMerge = System.nanoTime();
        mergeSort(arr);
        long endMerge = System.nanoTime();
        double durationMerge = (endMerge - startMerge) / 1_000_000.0;

        // Measure and print the time taken by Quick Sort.
        long startQuick = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long endQuick = System.nanoTime();
        double durationQuick = (endQuick - startQuick) / 1_000_000.0;

        // Output the performance results.
        System.out.println("Sorting Large Data Comparison:");
        System.out.println("Bubble Sort time: " + durationBubble + " ms");
        System.out.println("Merge Sort time:  " + durationMerge + " ms");
        System.out.println("Quick Sort time:  " + durationQuick + " ms");
    }
}


