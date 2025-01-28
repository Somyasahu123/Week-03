package linkedlist.singlylinkedlist.inventorymanagementsystem;
import java.util.Scanner;

class Item {
    String itemName;
    int itemID;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemID, int quantity, double price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head;

    // Add item at the beginning
    public void addAtBeginning(String itemName, int itemID, int quantity, double price) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add item at the end
    public void addAtEnd(String itemName, int itemID, int quantity, double price) {
        Item newItem = new Item(itemName, itemID, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }

    // Add item at a specific position
    public void addAtPosition(int position, String itemName, int itemID, int quantity, double price) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        Item newItem = new Item(itemName, itemID, quantity, price);
        if (position == 1) {
            newItem.next = head;
            head = newItem;
        } else {
            Item temp = head;
            for (int i = 1; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null) {
                System.out.println("Position out of range!");
            } else {
                newItem.next = temp.next;
                temp.next = newItem;
            }
        }
    }

    // Remove item by Item ID
    public void removeByItemID(int itemID) {
        if (head == null) {
            System.out.println("Inventory is empty!");
            return;
        }
        if (head.itemID == itemID) {
            head = head.next;
            System.out.println("Item removed successfully.");
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemID != itemID) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found!");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed successfully.");
        }
    }

    // Update quantity by Item ID
    public void updateQuantity(int itemID, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemID == itemID) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }

    // Search item by Item ID or Item Name
    public void searchItem(String itemName, int itemID) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemID == itemID || temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: Name: " + temp.itemName + ", ID: " + temp.itemID +
                        ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }

    // Calculate total inventory value
    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    // Sort inventory by Item Name or Price
    public void sortInventory(String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return; // Nothing to sort
        }
        head = mergeSort(head, criteria, ascending);
        System.out.println("Inventory sorted by " + criteria + " in " + (ascending ? "ascending" : "descending") + " order.");
    }

    private Item mergeSort(Item head, String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, criteria, ascending);
        Item right = mergeSort(nextOfMiddle, criteria, ascending);

        return sortedMerge(left, right, criteria, ascending);
    }

    private Item sortedMerge(Item a, Item b, String criteria, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (criteria.equalsIgnoreCase("Name")) {
            condition = ascending ? a.itemName.compareToIgnoreCase(b.itemName) < 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else { // Price
            condition = ascending ? a.price < b.price : a.price > b.price;
        }

        if (condition) {
            a.next = sortedMerge(a.next, b, criteria, ascending);
            return a;
        } else {
            b.next = sortedMerge(a, b.next, criteria, ascending);
            return b;
        }
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Display all items
    public void displayAllItems() {
        if (head == null) {
            System.out.println("No items in inventory.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.itemName + ", ID: " + temp.itemID +
                    ", Quantity: " + temp.quantity + ", Price: $" + temp.price);
            temp = temp.next;
        }
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search Item");
            System.out.println("7. Calculate Total Inventory Value");
            System.out.println("8. Sort Inventory");
            System.out.println("9. Display All Items");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    inventory.addAtBeginning(name, id, quantity, price);
                }
                case 2 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    inventory.addAtEnd(name, id, quantity, price);
                }
                case 3 -> {
                    System.out.print("Enter Position: ");
                    int position = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    inventory.addAtPosition(position, name, id, quantity, price);
                }
                case 4 -> {
                    System.out.print("Enter Item ID to Remove: ");
                    int id = sc.nextInt();
                    inventory.removeByItemID(id);
                }
                case 5 -> {
                    System.out.print("Enter Item ID to Update Quantity: ");
                    int id = sc.nextInt();
                    System.out.print("Enter New Quantity: ");
                    int quantity = sc.nextInt();
                    inventory.updateQuantity(id, quantity);
                }
                case 6 -> {
                    System.out.print("Enter Name or ID to Search: ");
                    String name = sc.next();
                    int id;
                    try {
                        id = Integer.parseInt(name);
                        inventory.searchItem("", id);
                    } catch (NumberFormatException e) {
                        inventory.searchItem(name, -1);
                    }
                }
                case 7 -> inventory.calculateTotalValue();
                case 8 -> {
                    System.out.print("Sort by Name or Price? ");
                    String criteria = sc.next();
                    System.out.print("Ascending (true/false)? ");
                    boolean ascending = sc.nextBoolean();
                    inventory.sortInventory(criteria, ascending);
                }
                case 9 -> inventory.displayAllItems();
                case 10 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 10);

        sc.close();
    }
}