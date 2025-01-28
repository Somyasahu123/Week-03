package linkedlist.doublylinkedlist.undoredofunctionality;
import java.util.Scanner;

class TextState {
    String textContent;
    TextState next;
    TextState prev;

    public TextState(String textContent) {
        this.textContent = textContent;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextState currentState;
    private int maxHistorySize;
    private int currentSize;

    public TextEditor(int maxHistorySize) {
        this.maxHistorySize = maxHistorySize;
        this.currentSize = 0;
        this.currentState = null;
    }

    // Add a new text state
    public void addState(String textContent) {
        TextState newState = new TextState(textContent);

        if (currentState == null) {
            currentState = newState;
        } else {
            if (currentSize == maxHistorySize) {
                removeOldestState();
            }

            newState.prev = currentState;
            currentState.next = newState;
            currentState = newState;
        }
        currentSize++;
        System.out.println("Text state added: " + textContent);
    }

    // Remove the oldest state when the history size exceeds the limit
    private void removeOldestState() {
        TextState oldestState = currentState.prev;
        if (oldestState != null) {
            oldestState.next = null;
            currentState.prev = null;
        }
        currentSize--;
    }

    // Undo functionality
    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.textContent);
        } else {
            System.out.println("No more undo actions.");
        }
    }

    // Redo functionality
    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.textContent);
        } else {
            System.out.println("No more redo actions.");
        }
    }

    // Display current text state
    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current Text State: " + currentState.textContent);
        } else {
            System.out.println("No text state available.");
        }
    }
}
public class TextEditorUndoRedo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor(10); // Limiting history to 10 states
        int choice;

        do {
            System.out.println("\n1. Add Text State");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current State");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}