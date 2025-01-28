package linkedlist.doublylinkedlist.moviemanagementsystem;
import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieManagement {
    private Movie head;
    private Movie tail;

    // Add a movie at the beginning
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
        System.out.println("Movie added at the beginning.");
    }

    // Add a movie at the end
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
        System.out.println("Movie added at the end.");
    }

    // Add a movie at a specific position
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (position == 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }

        Movie temp = head;
        int currentPosition = 1;

        while (temp != null && currentPosition < position - 1) {
            temp = temp.next;
            currentPosition++;
        }

        if (temp == null) {
            System.out.println("Invalid position. Adding at the end.");
            addMovieAtEnd(title, director, year, rating);
        } else {
            newMovie.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = newMovie;
            } else {
                tail = newMovie;
            }
            temp.next = newMovie;
            newMovie.prev = temp;
            System.out.println("Movie added at position " + position + ".");
        }
    }

    // Remove a movie by title
    public void removeMovieByTitle(String title) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
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
                System.out.println("Movie \"" + title + "\" removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie \"" + title + "\" not found.");
    }

    // Search for a movie by director or rating
    public void searchMovie(String director, double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director) || temp.rating == rating) {
                System.out.println("Movie Found: " + temp.title + ", Director: " + temp.director +
                        ", Year: " + temp.year + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movie found with the specified director or rating.");
        }
    }

    // Display all movies in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies in Forward Order:");
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display all movies in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies in Reverse Order:");
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    // Update a movie's rating based on the title
    public void updateMovieRating(String title, double newRating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Updated rating for \"" + title + "\" to " + newRating + ".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie \"" + title + "\" not found.");
    }
}


public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieManagement movieManagement = new MovieManagement();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Specific Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director or Rating");
            System.out.println("6. Display Movies in Forward Order");
            System.out.println("7. Display Movies in Reverse Order");
            System.out.println("8. Update Movie Rating");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Title: ");
                    String title = sc.next();
                    System.out.print("Enter Director: ");
                    String director = sc.next();
                    System.out.print("Enter Year of Release: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = sc.nextDouble();
                    movieManagement.addMovieAtBeginning(title, director, year, rating);
                }
                case 2 -> {
                    System.out.print("Enter Title: ");
                    String title = sc.next();
                    System.out.print("Enter Director: ");
                    String director = sc.next();
                    System.out.print("Enter Year of Release: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = sc.nextDouble();
                    movieManagement.addMovieAtEnd(title, director, year, rating);
                }
                case 3 -> {
                    System.out.print("Enter Title: ");
                    String title = sc.next();
                    System.out.print("Enter Director: ");
                    String director = sc.next();
                    System.out.print("Enter Year of Release: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    double rating = sc.nextDouble();
                    System.out.print("Enter Position: ");
                    int position = sc.nextInt();
                    movieManagement.addMovieAtPosition(title, director, year, rating, position);
                }
                case 4 -> {
                    System.out.print("Enter Movie Title to Remove: ");
                    String title = sc.next();
                    movieManagement.removeMovieByTitle(title);
                }
                case 5 -> {
                    System.out.print("Enter Director (or press enter to skip): ");
                    String director = sc.next();
                    System.out.print("Enter Rating (or -1 to skip): ");
                    double rating = sc.nextDouble();
                    movieManagement.searchMovie(director, rating);
                }
                case 6 -> movieManagement.displayForward();
                case 7 -> movieManagement.displayReverse();
                case 8 -> {
                    System.out.print("Enter Movie Title: ");
                    String title = sc.next();
                    System.out.print("Enter New Rating: ");
                    double newRating = sc.nextDouble();
                    movieManagement.updateMovieRating(title, newRating);
                }
                case 9 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 9);

        sc.close();
    }
}
