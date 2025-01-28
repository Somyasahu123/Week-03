package linkedlist.circularlinkedlist.taskscheduler;

class Task {
    int taskID;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskID, String taskName, int priority, String dueDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskScheduler {
    private Task head;

    public CircularTaskScheduler() {
        head = null;
    }

    // Add task at the beginning of the circular linked list
    public void addTaskAtBeginning(int taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head; // Circular reference
        } else {
            newTask.next = head;
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            head = newTask; // Set the new task as head
        }
    }

    // Add task at the end of the circular linked list
    public void addTaskAtEnd(int taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head; // Circular reference
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    // Add task at a specific position
    public void addTaskAtPosition(int position, int taskID, String taskName, int priority, String dueDate) {
        if (position == 1) {
            addTaskAtBeginning(taskID, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskID, taskName, priority, dueDate);
        Task temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
            if (temp == head) break;  // Prevent going beyond the list
        }
        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove task by Task ID
    public void removeTask(int taskID) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task temp = head;
        Task prev = null;
        do {
            if (temp.taskID == taskID) {
                if (prev == null) {  // Task to be removed is the head
                    if (temp.next == head) {
                        head = null;  // Only one task
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
                System.out.println("Task with ID " + taskID + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task with ID " + taskID + " not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTask() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        System.out.println("Current Task ID: " + temp.taskID);
        System.out.println("Task Name: " + temp.taskName);
        System.out.println("Priority: " + temp.priority);
        System.out.println("Due Date: " + temp.dueDate);

        head = temp.next;  // Move to the next task
    }

    // Display all tasks starting from the head
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskID + " | Name: " + temp.taskName + " | Priority: " + temp.priority + " | Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskID + " | Name: " + temp.taskName + " | Priority: " + temp.priority + " | Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with the given priority.");
        }
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        CircularTaskScheduler scheduler = new CircularTaskScheduler();

        // Adding tasks
        scheduler.addTaskAtEnd(1, "Task 1", 3, "2025-02-20");
        scheduler.addTaskAtEnd(2, "Task 2", 2, "2025-03-15");
        scheduler.addTaskAtEnd(3, "Task 3", 1, "2025-04-10");

        // Display all tasks
        System.out.println("Displaying all tasks:");
        scheduler.displayAllTasks();

        // Add a task at the beginning
        scheduler.addTaskAtBeginning(4, "Task 4", 5, "2025-01-10");
        System.out.println("\nDisplaying all tasks after adding at the beginning:");
        scheduler.displayAllTasks();

        // Add a task at a specific position
        scheduler.addTaskAtPosition(2, 5, "Task 5", 4, "2025-02-15");
        System.out.println("\nDisplaying all tasks after adding at position 2:");
        scheduler.displayAllTasks();

        // Remove a task by Task ID
        scheduler.removeTask(2);
        System.out.println("\nDisplaying all tasks after removing Task ID 2:");
        scheduler.displayAllTasks();

        // View the current task
        System.out.println("\nViewing current task:");
        scheduler.viewCurrentTask();

        // Search for tasks with a specific priority
        System.out.println("\nSearching for tasks with priority 4:");
        scheduler.searchTaskByPriority(4);
    }
}