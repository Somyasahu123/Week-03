package SortingAlgorithm.countingsort;
import java.util.Arrays;

public class SortStudentAges{
    // Method to perform Counting Sort on an array of student ages
    public static int[] countSort(int studentAge[]) {
        int max = Integer.MIN_VALUE; // Variable to store the maximum age in the array

        // Finding the maximum value in the array
        for (int i = 0; i < studentAge.length; i++) {
            if (studentAge[i] > max) {
                max = studentAge[i];
            }
        }

        // Creating a count array of size 'max' to store the frequency of each element
        int count[] = new int[max];

        // Initializing the count array with 0 (this step is redundant in Java, as arrays are initialized with 0 by default)
        for (int i = 0; i < max; i++) {
            count[i] = 0;
        }

        // Storing the frequency of each element in the count array
        for (int i = 0; i < studentAge.length; i++) {
            count[studentAge[i] - 1]++; // Subtracting 1 to adjust for 0-based indexing
        }

        // Sorting the original array using the count array
        int index = 0;
        for (int i = 0; i < max; i++) {
            while (count[i] > 0) {
                studentAge[index++] = i + 1; // Restoring the sorted elements
                count[i]--;
            }
        }

        return studentAge; // Returning the sorted array
    }

    public static void main(String[] args) {
        int studentAge[] = {12, 11, 15, 16, 17, 14, 15, 12, 18, 17, 15, 14};

        System.out.println("Before count sort : " + Arrays.toString(studentAge));
        System.out.println();

        System.out.println("After count sort : " + Arrays.toString(countSort(studentAge)));
    }
}
