import CompareLinearBinarySearch.BinaryLinearSearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryLinearSearchTest {
    @Test
    public void testBinaryLinearSearch() {
        // Unsorted array for Linear Search
        int[] unsortedArr = {15, 18, 2, 3, 6, 12};
        // Sorted array for Binary Search
        int[] sortedArr = {2, 3, 6, 12, 15, 18};
        int target = 12;
        BinaryLinearSearch bs = new BinaryLinearSearch();
        // Linear search on the unsorted array
        int linearIndex = bs.linearSearch(unsortedArr, target);
        // Binary search on the sorted array
        int binaryIndex = bs.binarySearch(sortedArr, target);

        // In the unsorted array, the target 12 is at index 5.
        // In the sorted array, the target 12 is at index 3.
        assertEquals(5, linearIndex, "Linear search should return index 5 for target 12 in the unsorted array.");
        assertEquals(3, binaryIndex, "Binary search should return index 3 for target 12 in the sorted array.");
    }
}
