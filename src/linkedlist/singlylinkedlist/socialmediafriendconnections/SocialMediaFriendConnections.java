package linkedlist.singlylinkedlist.socialmediafriendconnections;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
class User {
    int userID;
    String name;
    int age;
    List<Integer> friendIDs;
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendIDs = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    // Add a new user
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        System.out.println("User added successfully.");
    }

    // Find a user by User ID
    private User findUserByID(int userID) {
        User temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIDs.contains(userID2)) {
            user1.friendIDs.add(userID2);
        }
        if (!user2.friendIDs.contains(userID1)) {
            user2.friendIDs.add(userID1);
        }
        System.out.println("Friend connection added successfully.");
    }

    // Remove a friend connection
    public void removeFriendConnection(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIDs.remove(Integer.valueOf(userID2));
        user2.friendIDs.remove(Integer.valueOf(userID1));
        System.out.println("Friend connection removed successfully.");
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        List<Integer> mutualFriends = new ArrayList<>(user1.friendIDs);
        mutualFriends.retainAll(user2.friendIDs);

        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends found.");
        } else {
            System.out.println("Mutual Friends: " + mutualFriends);
        }
    }

    // Display all friends of a specific user
    public void displayAllFriends(int userID) {
        User user = findUserByID(userID);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        if (user.friendIDs.isEmpty()) {
            System.out.println(user.name + " has no friends.");
        } else {
            System.out.println(user.name + "'s Friends: " + user.friendIDs);
        }
    }

    // Search for a user by Name or User ID
    public void searchUser(String name, int userID) {
        User temp = head;

        while (temp != null) {
            if (temp.userID == userID || temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: ID: " + temp.userID + ", Name: " + temp.name + ", Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // Count the number of friends for each user
    public void countFriends() {
        User temp = head;

        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIDs.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Display all users
    public void displayAllUsers() {
        if (head == null) {
            System.out.println("No users in the system.");
            return;
        }

        User temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.userID + ", Name: " + temp.name + ", Age: " + temp.age +
                    ", Friends: " + temp.friendIDs);
            temp = temp.next;
        }
    }
}



public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display All Friends");
            System.out.println("6. Search User");
            System.out.println("7. Count Friends");
            System.out.println("8. Display All Users");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter User ID: ");
                    int userID = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    socialMedia.addUser(userID, name, age);
                }
                case 2 -> {
                    System.out.print("Enter First User ID: ");
                    int userID1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    int userID2 = sc.nextInt();
                    socialMedia.addFriendConnection(userID1, userID2);
                }
                case 3 -> {
                    System.out.print("Enter First User ID: ");
                    int userID1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    int userID2 = sc.nextInt();
                    socialMedia.removeFriendConnection(userID1, userID2);
                }
                case 4 -> {
                    System.out.print("Enter First User ID: ");
                    int userID1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    int userID2 = sc.nextInt();
                    socialMedia.findMutualFriends(userID1, userID2);
                }
                case 5 -> {
                    System.out.print("Enter User ID: ");
                    int userID = sc.nextInt();
                    socialMedia.displayAllFriends(userID);
                }
                case 6 -> {
                    System.out.print("Enter User ID or Name to Search: ");
                    String input = sc.next();
                    try {
                        int userID = Integer.parseInt(input);
                        socialMedia.searchUser("", userID);
                    } catch (NumberFormatException e) {
                        socialMedia.searchUser(input, -1);
                    }
                }
                case 7 -> socialMedia.countFriends();
                case 8 -> socialMedia.displayAllUsers();
                case 9 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 9);

        sc.close();
    }
}