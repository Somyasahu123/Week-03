package StacksAndQueues.CircularTourProblem;

class Circular {
    static int findStartingPump(int[] petrol, int[] distance) {
        int totalPetrol = 0, totalDistance = 0;
        int startIndex = 0, currentSurplus = 0;

        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            currentSurplus += petrol[i] - distance[i];

            // If surplus becomes negative, reset starting point
            if (currentSurplus < 0) {
                startIndex = i + 1;  // Start from next pump
                currentSurplus = 0;  // Reset surplus
            }
        }

        return (totalPetrol >= totalDistance) ? startIndex : -1;
    }
}

public class CircularTour {

    public static void main(String[] args) {

        Circular tour = new Circular();
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = tour.findStartingPump(petrol, distance);
        if (start != -1) {
            System.out.println("Start the tour from petrol pump index: " + start);
        } else {
            System.out.println("Tour is not possible.");
        }
    }
}
