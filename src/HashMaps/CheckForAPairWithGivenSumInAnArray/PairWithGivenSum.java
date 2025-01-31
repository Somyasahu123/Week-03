package HashMaps.CheckForAPairWithGivenSumInAnArray;

import java.util.HashMap;

class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : arr) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                return true;  // Pair found
            }
            map.put(num, true);
        }
        return false;  // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 10};
        int target = 14;

        System.out.println("Pair with given sum exists: " + hasPairWithSum(arr, target)); // Output: true
    }
}
