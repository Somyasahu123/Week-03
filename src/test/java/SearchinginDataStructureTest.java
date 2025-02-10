import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;
import static org.junit.jupiter.api.Assertions.*;

public class SearchinginDataStructureTest {

    @Test
    public void testSearchOperations() {
        // Define dataset size
        int n = 10_000; // Smaller dataset for testing efficiency
        int[] arr = new int[n];
        Random rand = new Random();

        // Fill the array with random integers.
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1_000_000);
        }

        // Choose a target element from the array (ensures it exists)
        int target = arr[n / 2]; // Picking an element from the middle

        // -------------------------------
        // Array: Linear Search
        // -------------------------------
        boolean foundInArray = false;
        for (int value : arr) {
            if (value == target) {
                foundInArray = true;
                break;
            }
        }

        // -------------------------------
        // HashSet: O(1) on average
        // -------------------------------
        HashSet<Integer> hashSet = new HashSet<>();
        for (int value : arr) {
            hashSet.add(value);
        }
        boolean foundInHashSet = hashSet.contains(target);

        // -------------------------------
        // TreeSet: O(log N)
        // -------------------------------
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int value : arr) {
            treeSet.add(value);
        }
        boolean foundInTreeSet = treeSet.contains(target);

        // Assertions: All methods should return true for the same target
        assertTrue(foundInArray, "Linear search should find the target");
        assertTrue(foundInHashSet, "HashSet should find the target");
        assertTrue(foundInTreeSet, "TreeSet should find the target");
    }
}

