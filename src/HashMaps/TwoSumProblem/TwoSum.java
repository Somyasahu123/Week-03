package HashMaps.TwoSumProblem;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
    public static int[] findIndicesPair(int arr[] , int target){

        Map<Integer , Integer> map = new HashMap<>();

        // Store array elements and their indices in the map
        for(int i=0;i<arr.length;i++){
            map.put(arr[i] , i);
        }


        // Iterate through the array to find the pair
        for(int i=0;i<arr.length;i++){
            int rem = target - arr[i]; // Calculate the remaining value needed


            if (map.containsKey(rem)) // Check if the complement exists in the map
            {
                int index = map.get(rem);
                if (index == i) continue; // Skip if it's the same element
                return new int []{i , index}; // Return the indices if found
            }
        }
        return new int[]{-1,-1}; // Return -1, -1 if no pair is found
    }


    public static void main(String[] args) {
        int arr[] = {2,4,8,16,32};
        int target = 10;
        int ans[] = findIndicesPair(arr,target);
        System.out.println(ans[0] + " " + ans[1]); // Print the result
    }
}