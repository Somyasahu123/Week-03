import SortingLargeDataEfficiently.CompareSorting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class CompareSortingTest {

    // Helper method to create a copy of the array for independent sorting verification
    private int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    @Test
    public void testBubbleSortCorrectness() {
        int[] arr = {10, 20, 5, 2, 50};
        int[] expected = copyArray(arr);
        Arrays.sort(expected); // Java's built-in sort for correctness check

        CompareSorting.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Bubble Sort failed");
    }

    @Test
    public void testMergeSortCorrectness() {
        int[] arr = {10, 20, 5, 2, 50};
        int[] expected = copyArray(arr);
        Arrays.sort(expected);

        CompareSorting.mergeSort(arr);
        assertArrayEquals(expected, arr, "Merge Sort failed");
    }

    @Test
    public void testQuickSortCorrectness() {
        int[] arr = {10, 20, 5, 2, 50};
        int[] expected = copyArray(arr);
        Arrays.sort(expected);

        CompareSorting.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "Quick Sort failed");
    }

    @Test
    public void testSortingWithEmptyArray() {
        int[] arr = {};
        int[] expected = {};

        CompareSorting.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Bubble Sort failed on empty array");

        CompareSorting.mergeSort(arr);
        assertArrayEquals(expected, arr, "Merge Sort failed on empty array");

        CompareSorting.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "Quick Sort failed on empty array");
    }

    @Test
    public void testSortingWithSingleElementArray() {
        int[] arr = {5};
        int[] expected = {5};

        CompareSorting.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Bubble Sort failed on single-element array");

        CompareSorting.mergeSort(arr);
        assertArrayEquals(expected, arr, "Merge Sort failed on single-element array");

        CompareSorting.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "Quick Sort failed on single-element array");
    }

    @Test
    public void testSortingWithAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = copyArray(arr);

        CompareSorting.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Bubble Sort failed on already sorted array");

        CompareSorting.mergeSort(arr);
        assertArrayEquals(expected, arr, "Merge Sort failed on already sorted array");

        CompareSorting.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "Quick Sort failed on already sorted array");
    }

    @Test
    public void testSortingWithReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = copyArray(arr);
        Arrays.sort(expected);

        CompareSorting.bubbleSort(arr);
        assertArrayEquals(expected, arr, "Bubble Sort failed on reverse sorted array");

        CompareSorting.mergeSort(arr);
        assertArrayEquals(expected, arr, "Merge Sort failed on reverse sorted array");

        CompareSorting.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr, "Quick Sort failed on reverse sorted array");
    }

    @Test
    public void testSortingPerformance() {
        int[] largeArr = new int[1000];
        for (int i = 0; i < largeArr.length; i++) {
            largeArr[i] = (int) (Math.random() * 1000);
        }
        int[] expected = copyArray(largeArr);
        Arrays.sort(expected);

        int[] bubbleArr = copyArray(largeArr);
        long startBubble = System.nanoTime();
        CompareSorting.bubbleSort(bubbleArr);
        long endBubble = System.nanoTime();
        assertArrayEquals(expected, bubbleArr, "Bubble Sort failed on large data");
        System.out.println("Bubble Sort took: " + (endBubble - startBubble) / 1_000_000.0 + " ms");

        int[] mergeArr = copyArray(largeArr);
        long startMerge = System.nanoTime();
        CompareSorting.mergeSort(mergeArr);
        long endMerge = System.nanoTime();
        assertArrayEquals(expected, mergeArr, "Merge Sort failed on large data");
        System.out.println("Merge Sort took: " + (endMerge - startMerge) / 1_000_000.0 + " ms");

        int[] quickArr = copyArray(largeArr);
        long startQuick = System.nanoTime();
        CompareSorting.quickSort(quickArr, 0, quickArr.length - 1);
        long endQuick = System.nanoTime();
        assertArrayEquals(expected, quickArr, "Quick Sort failed on large data");
        System.out.println("Quick Sort took: " + (endQuick - startQuick) / 1_000_000.0 + " ms");
    }
}

