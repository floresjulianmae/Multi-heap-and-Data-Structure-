import java.util.PriorityQueue;
import java.util.Scanner;

class Task implements Comparable<Task> {
    private String description;
    private int priority;

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority); // Lower priority number = higher priority
    }

    @Override
    public String toString() {
        return "Task: " + description + " | Priority: " + priority;
    }
}

public class PriorityTaskManager {
    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Priority Task Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Highest Priority Task");
            System.out.println("3. Process Highest Priority Task");
            System.out.println("4. Display All Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task priority (lower number = higher priority): ");
                    int priority = scanner.nextInt();
                    taskQueue.offer(new Task(description, priority));
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks in the queue.");
                    } else {
                        System.out.println("Highest Priority Task: " + taskQueue.peek());
                    }
                    break;

                case 3:
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks to process.");
                    } else {
                        System.out.println("Processing Task: " + taskQueue.poll());
                    }
                    break;

                case 4:
                    if (taskQueue.isEmpty()) {
                        System.out.println("No tasks in the queue.");
                    } else {
                        System.out.println("All Tasks:");
                        for (Task task : taskQueue) {
                            System.out.println(task);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
