package linkedlist.doublylinkedlist.librarymanagementsystem;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagement {
    private Book head;
    private Book tail;

    // Add a book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        System.out.println("Book added at the beginning.");
    }

    // Add a book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        System.out.println("Book added at the end.");
    }

    // Add a book at a specific position
    public void addBookAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (position == 1) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        Book temp = head;
        int currentPosition = 1;

        while (temp != null && currentPosition < position - 1) {
            temp = temp.next;
            currentPosition++;
        }

        if (temp == null) {
            System.out.println("Invalid position. Adding at the end.");
            addBookAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newBook.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newBook;
            } else {
                tail = newBook;
            }
            temp.next = newBook;
            newBook.prev = temp;
            System.out.println("Book added at position " + position + ".");
        }
    }

    // Remove a book by Book ID
    public void removeBookById(int bookId) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }
                System.out.println("Book with ID " + bookId + " removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Search for a book by Title or Author
    public void searchBook(String title, String author) {
        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title) || temp.author.equalsIgnoreCase(author)) {
                System.out.println("Book Found: ID: " + temp.bookId + ", Title: " + temp.title +
                        ", Author: " + temp.author + ", Genre: " + temp.genre +
                        ", Available: " + temp.isAvailable);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No book found with the specified title or author.");
        }
    }

    // Update a book's availability status
    public void updateBookAvailability(int bookId, boolean isAvailable) {
        Book temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                System.out.println("Updated availability status for book with ID " + bookId + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Books in Forward Order:");
        Book temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title +
                    ", Author: " + temp.author + ", Genre: " + temp.genre +
                    ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Books in Reverse Order:");
        Book temp = tail;
        while (temp != null) {
            System.out.println("ID: " + temp.bookId + ", Title: " + temp.title +
                    ", Author: " + temp.author + ", Genre: " + temp.genre +
                    ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    // Count the total number of books
    public int countBooks() {
        int count = 0;
        Book temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Specific Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title or Author");
            System.out.println("6. Update Book Availability");
            System.out.println("7. Display Books in Forward Order");
            System.out.println("8. Display Books in Reverse Order");
            System.out.println("9. Count Total Books");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Title: ");
                    String title = sc.next();
                    System.out.print("Enter Author: ");
                    String author = sc.next();
                    System.out.print("Enter Genre: ");
                    String genre = sc.next();
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter Availability (true/false): ");
                    boolean isAvailable = sc.nextBoolean();
                    library.addBookAtBeginning(title, author, genre, bookId, isAvailable);
                }
                case 2 -> {
                    System.out.print("Enter Title: ");
                    String title = sc.next();
                    System.out.print("Enter Author: ");
                    String author = sc.next();
                    System.out.print("Enter Genre: ");
                    String genre = sc.next();
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter Availability (true/false): ");
                    boolean isAvailable = sc.nextBoolean();
                    library.addBookAtEnd(title, author, genre, bookId, isAvailable);
                }
                case 3 -> {
                    System.out.print("Enter Title: ");
                    String title = sc.next();
                    System.out.print("Enter Author: ");
                    String author = sc.next();
                    System.out.print("Enter Genre: ");
                    String genre = sc.next();
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter Availability (true/false): ");
                    boolean isAvailable = sc.nextBoolean();
                    System.out.print("Enter Position: ");
                    int position = sc.nextInt();
                    library.addBookAtPosition(title, author, genre, bookId, isAvailable, position);
                }
                case 4 -> {
                    System.out.print("Enter Book ID to Remove: ");
                    int bookId = sc.nextInt();
                    library.removeBookById(bookId);
                }
                case 5 -> {
                    System.out.print("Enter Title (or press enter to skip): ");
                    String title = sc.next();
                    System.out.print("Enter Author (or press enter to skip): ");
                    String author = sc.next();
                    library.searchBook(title, author);
                }
                case 6 -> {
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter Availability (true/false): ");
                    boolean isAvailable = sc.nextBoolean();
                    library.updateBookAvailability(bookId, isAvailable);
                }
                case 7 -> library.displayForward();
                case 8 -> library.displayReverse();
                case 9 -> System.out.println("Total Books: " + library.countBooks());
                case 10 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 10);

        sc.close();
    }
}