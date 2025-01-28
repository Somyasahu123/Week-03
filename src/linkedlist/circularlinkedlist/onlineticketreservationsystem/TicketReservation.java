package linkedlist.circularlinkedlist.onlineticketreservationsystem;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head;

    // Add a new ticket reservation at the end of the circular list
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            newTicket.next = head; // Circular reference
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
        System.out.println("Ticket with ID " + ticketID + " added.");
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;

        do {
            if (temp.ticketID == ticketID) {
                if (prev == null) { // Removing the head ticket
                    if (temp.next == head) { // Only one ticket in the list
                        head = null;
                    } else {
                        prev = head;
                        while (prev.next != head) {
                            prev = prev.next;
                        }
                        head = head.next;
                        prev.next = head;
                    }
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Ticket with ID " + ticketID + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket with ID " + ticketID + " not found.");
    }

    // Display all tickets
    public void displayAllTickets() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket temp = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketID + " | Customer: " + temp.customerName + " | Movie: " + temp.movieName + " | Seat: " + temp.seatNumber + " | Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchKey) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(searchKey) || temp.movieName.equalsIgnoreCase(searchKey)) {
                System.out.println("Found Ticket - Ticket ID: " + temp.ticketID + " | Customer: " + temp.customerName + " | Movie: " + temp.movieName + " | Seat: " + temp.seatNumber + " | Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tickets found for the given search key: " + searchKey);
        }
    }

    // Calculate the total number of booked tickets
    public int calculateTotalTickets() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}

public class TicketReservation {
    public static void main(String[] args) {
        TicketReservationSystem reservationSystem = new TicketReservationSystem();

        // Adding tickets
        reservationSystem.addTicket(101, "Alice", "Avengers: Endgame", "A1", "2025-01-30 18:00");
        reservationSystem.addTicket(102, "Bob", "Inception", "B3", "2025-01-30 20:00");
        reservationSystem.addTicket(103, "Charlie", "The Matrix", "C5", "2025-01-31 19:00");

        // Display all tickets
        reservationSystem.displayAllTickets();

        // Search for tickets
        System.out.println("\nSearching for tickets by customer name 'Alice':");
        reservationSystem.searchTicket("Alice");

        System.out.println("\nSearching for tickets by movie name 'Inception':");
        reservationSystem.searchTicket("Inception");

        // Remove a ticket
        System.out.println("\nRemoving ticket with ID 102:");
        reservationSystem.removeTicket(102);

        // Display all tickets after removal
        System.out.println("\nTickets after removal:");
        reservationSystem.displayAllTickets();

        // Calculate total tickets
        System.out.println("\nTotal number of tickets booked: " + reservationSystem.calculateTotalTickets());
    }
}