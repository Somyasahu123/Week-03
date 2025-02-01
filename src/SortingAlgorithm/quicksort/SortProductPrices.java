package SortingAlgorithm.quicksort;
import java.util.Scanner;

class ProductPriceSorter {
    // Quick Sort function
    public void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);

            // Recursively sort partitions
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Partition function
    private int partition(double[] prices, int low, int high) {
        double pivot = prices[high];  // Pivot element
        int i = low - 1;              // Index of smaller element

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap prices[i + 1] and pivot (prices[high])
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1;
    }

    // Display product prices
    public void displayProductPrices(double[] prices) {
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
}

public class SortProductPrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductPriceSorter sorter = new ProductPriceSorter();

        // Input the number of product prices
        System.out.print("Enter the number of product prices: ");
        int numPrices = scanner.nextInt();

        double[] productPrices = new double[numPrices];

        // Input product prices
        System.out.println("Enter the product prices:");
        for (int i = 0; i < numPrices; i++) {
            System.out.print("Price " + (i + 1) + ": ");
            productPrices[i] = scanner.nextDouble();
        }

        // Sort and display product prices
        System.out.println("Sorting product prices using Quick Sort...");
        sorter.quickSort(productPrices, 0, numPrices - 1);

        System.out.println("Sorted product prices:");
        sorter.displayProductPrices(productPrices);

        scanner.close();
    }
}
