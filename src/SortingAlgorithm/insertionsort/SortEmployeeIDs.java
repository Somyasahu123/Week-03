package SortingAlgorithm.insertionsort;
import java.util.Scanner;

class EmployeeSorter {
    // Insertion Sort to sort employee IDs
    public void insertionSort(int[] ids) {
        int n = ids.length;

        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;

            // Move elements greater than key one position ahead
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }

            // Insert the key at the correct position
            ids[j + 1] = key;
        }
    }

    // Display employee IDs
    public void displayEmployeeIds(int[] ids) {
        for (int id : ids) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
}

public class SortEmployeeIDs{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeSorter sorter = new EmployeeSorter();

        // Input number of employees
        System.out.print("Enter the number of employees: ");
        int numEmployees = scanner.nextInt();

        int[] employeeIds = new int[numEmployees];

        // Input employee IDs
        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < numEmployees; i++) {
            System.out.print("Employee " + (i + 1) + ": ");
            employeeIds[i] = scanner.nextInt();
        }

        // Sort and display employee IDs
        System.out.println("Sorting Employee IDs using Insertion Sort...");
        sorter.insertionSort(employeeIds);

        System.out.println("Sorted Employee IDs:");
        sorter.displayEmployeeIds(employeeIds);

        scanner.close();
    }
}
