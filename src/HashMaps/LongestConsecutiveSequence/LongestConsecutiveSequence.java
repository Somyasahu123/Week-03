package HashMaps.LongestConsecutiveSequence;
import java.util.HashMap;

class LongestConsecutiveSequenceMap {
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {  // Process only if not seen before
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int newLength = left + right + 1;

                // Store the sequence length at the boundaries
                map.put(num, newLength);
                map.put(num - left, newLength);
                map.put(num + right, newLength);

                maxLength = Math.max(maxLength, newLength);
            }
        }
        return maxLength;
    }
}

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        LongestConsecutiveSequenceMap longest = new LongestConsecutiveSequenceMap();

        System.out.println("Longest Consecutive Sequence Length: " + longest.longestConsecutive(nums));
    }
}
