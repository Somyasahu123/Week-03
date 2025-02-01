package SortingAlgorithm.bubblesort;
import java.util.Scanner;

class StudentSorter {
    // Bubble Sort to sort student marks in ascending order
    public void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap adjacent elements
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // Break if no elements were swapped, list is already sorted
            if (!swapped) break;
        }
    }

    // Method to display sorted marks
    public void displayMarks(int[] marks) {
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
}
public class SortStudentMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSorter sorter = new StudentSorter();

        // Input the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[] marks = new int[numStudents];

        // Input student marks
        System.out.println("Enter the marks of students:");
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        // Sort and display the marks
        System.out.println("Sorting marks using Bubble Sort...");
        sorter.bubbleSort(marks);

        System.out.println("Sorted marks in ascending order:");
        sorter.displayMarks(marks);

        scanner.close();
    }
}
