package SortingAlgorithm.heapsort;
import java.util.Scanner;

class JobApplicantSalarySorter {
    // Heap Sort function
    public void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Heapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Heapify function
    private void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // Check if right child is larger than root
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            int swap = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = swap;

            heapify(salaries, n, largest);
        }
    }

    // Display sorted salaries
    public void displaySalaries(int[] salaries) {
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }
}


public class SortJobApplicantsBySalary{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JobApplicantSalarySorter sorter = new JobApplicantSalarySorter();

        // Input the number of salary demands
        System.out.print("Enter the number of job applicants: ");
        int numApplicants = scanner.nextInt();

        int[] salaries = new int[numApplicants];

        // Input salary demands
        System.out.println("Enter the expected salaries:");
        for (int i = 0; i < numApplicants; i++) {
            System.out.print("Salary " + (i + 1) + ": ");
            salaries[i] = scanner.nextInt();
        }

        // Sort and display salaries
        System.out.println("Sorting salaries using Heap Sort...");
        sorter.heapSort(salaries);

        System.out.println("Sorted salaries:");
        sorter.displaySalaries(salaries);

        scanner.close();
    }
}