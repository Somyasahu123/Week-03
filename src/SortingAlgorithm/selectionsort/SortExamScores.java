package SortingAlgorithm.selectionsort;
import java.util.Scanner;

class ExamScoreSorter {
    // Selection Sort function
    public void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Display exam scores
    public void displayExamScores(int[] scores) {
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
}

public class SortExamScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExamScoreSorter sorter = new ExamScoreSorter();

        // Input the number of exam scores
        System.out.print("Enter the number of exam scores: ");
        int numScores = scanner.nextInt();

        int[] examScores = new int[numScores];

        // Input exam scores
        System.out.println("Enter the exam scores:");
        for (int i = 0; i < numScores; i++) {
            System.out.print("Score " + (i + 1) + ": ");
            examScores[i] = scanner.nextInt();
        }

        // Sort and display exam scores
        System.out.println("Sorting exam scores using Selection Sort...");
        sorter.selectionSort(examScores);

        System.out.println("Sorted exam scores:");
        sorter.displayExamScores(examScores);

        scanner.close();
    }
}
