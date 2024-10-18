package org.example.myjavaprojects.ExpenseTrackerPro;

// Main class to run the expense tracker application
import java.util.Scanner; // Importing Scanner to take user input

public class ExpenseTracker {

    public static void main(String[] args) {
        ExpenseManager manager = new ExpenseManager(); // Creating an instance of ExpenseManager
        Scanner scanner = new Scanner(System.in); // Initializing the Scanner to read input from the console
        boolean running = true; // Boolean flag to control the loop

        // Load existing expenses from file (if any)
        try {
            manager.loadFromFile("expenses.txt"); // Attempt to load saved expenses from a file
        } catch (Exception e) {
            System.out.println("No previous expenses found."); // Inform user if no expenses are found
        }

        // Main loop to interact with the user
        while (running) {
            // Displaying options for the user
            System.out.println("1. Add Expense\n2. View Expenses\n3. View Total by Category\n4. Remove an expense from the list.\n5. Save and Exit");
            int choice = scanner.nextInt(); // Read user's choice as an integer
            scanner.nextLine(); // Consume the newline character left after nextInt()

            switch (choice) {
                case 1:
                    // Adding a new expense
                    System.out.println("Enter description:");
                    String description = scanner.nextLine(); // Read the description

                    System.out.println("Enter amount:");
                    double amount = scanner.nextDouble(); // Read the amount
                    scanner.nextLine(); // Consume the newline character

                    System.out.println("Enter category:");
                    String category = scanner.nextLine(); // Read the category

                    // Add the new expense to the manager
                    manager.addExpense(new Expense(description, amount, category));
                    break;
                case 2:
                    // View all expenses
                    manager.viewExpenses(); // Call the method to display all expenses
                    break;
                case 3:
                    // View total expense by category
                    manager.totalByCategory(); // Call the method to calculate and display totals
                    break;

                case 4:
                        // Remove expense
                        System.out.println("Enter the description of the expense to remove:");
                        manager.removeExpenseAndNotify(scanner.nextLine());
                        break;
                case 5:
                    // Save expenses to file and exit
                    try {
                        manager.saveToFile("expenses.txt"); // Save expenses to file
                        System.out.println("Expenses saved. Exiting..."); // Inform the user
                    } catch (Exception e) {
                        System.out.println("Error saving expenses."); // Error handling for file operations
                    }
                    running = false; // End the loop to exit the program
                    break;
                default:
                    // Handle invalid input
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close(); // Close the scanner to avoid resource leaks
    }
}
