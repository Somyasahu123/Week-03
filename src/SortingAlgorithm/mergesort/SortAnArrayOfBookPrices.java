package SortingAlgorithm.mergesort;
import java.util.Scanner;

class BookPriceSorter {
    // Merge Sort function
    public void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort first and second halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Merge two sorted subarrays
    private void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp arrays
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        // Copy data to temp arrays
        System.arraycopy(prices, left, leftArray, 0, n1);
        System.arraycopy(prices, mid + 1, rightArray, 0, n2);

        // Initial indices for merging
        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from leftArray
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from rightArray
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Display book prices
    public void displayBookPrices(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
}

public class SortAnArrayOfBookPrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookPriceSorter sorter = new BookPriceSorter();

        // Input the number of book prices
        System.out.print("Enter the number of book prices: ");
        int numPrices = scanner.nextInt();

        double[] bookPrices = new double[numPrices];

        // Input book prices
        System.out.println("Enter the book prices:");
        for (int i = 0; i < numPrices; i++) {
            System.out.print("Price " + (i + 1) + ": ");
            bookPrices[i] = scanner.nextDouble();
        }

        // Sort and display book prices
        System.out.println("Sorting book prices using Merge Sort...");
        sorter.mergeSort(bookPrices, 0, numPrices - 1);

        System.out.println("Sorted book prices:");
        sorter.displayBookPrices(bookPrices);

        scanner.close();
    }
}
