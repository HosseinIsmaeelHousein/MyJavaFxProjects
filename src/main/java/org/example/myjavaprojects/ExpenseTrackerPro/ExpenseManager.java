package org.example.myjavaprojects.ExpenseTrackerPro;

// Class that manages all the expenses (adding, viewing, saving, etc.)
import java.util.ArrayList; // Importing ArrayList to store multiple expenses
import java.util.HashMap; // Importing HashMap to categorize expenses
import java.io.*; // Importing for file handling

public class ExpenseManager {
    private ArrayList<Expense> expenses = new ArrayList<>(); // List to store all the expenses

    // Method to add a new expense to the list
    public void addExpense(Expense expense) {
        expenses.add(expense); // Add the provided expense object to the list
    }

    public boolean removeExpense(String description) {
        for (Expense expense : expenses) {
            if (expense.getDescription().equalsIgnoreCase(description)) {
                expenses.remove(expense);
                return true;
            }
        }
        return false;
    }

    // Method to remove an expense and notify if successful
    public void removeExpenseAndNotify(String description) {
        if (removeExpense(description)) {
            System.out.println("Expense removed successfully.");
        } else {
            System.out.println("No expense found with the given description.");
        }
    }


    // Method to view (print) all the stored expenses
    public void viewExpenses() {
        // Loop through the list of expenses and print each one
        for (Expense expense : expenses) {
            System.out.println(expense); // Using toString() method to display expense details
        }
    }

    // Method to calculate and display total expenses by category
    public void totalByCategory() {
        // HashMap to store total amounts for each category
        HashMap<String, Double> categoryTotals = new HashMap<>();

        // Loop through the list of expenses
        for (Expense expense : expenses) {
            // Update the total for the expense category by adding the current amount
            categoryTotals.put(expense.getCategory(),
                    categoryTotals.getOrDefault(expense.getCategory(), 0.0) + expense.getAmount());
        }

        // Print the total for each category
        for (String category : categoryTotals.keySet()) {
            System.out.println("Category: " + category + ", Total: " + categoryTotals.get(category));
        }
    }

    // Method to save expenses to a file
    public void saveToFile(String filename) throws IOException {
        // Create a BufferedWriter to write to the specified file
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        // Loop through the expenses list and write each one to the file
        for (Expense expense : expenses) {
            // Write expense details in CSV format: description,amount,category
            writer.write(expense.getDescription() + "," + expense.getAmount() + "," + expense.getCategory());
            writer.newLine(); // Move to the next line after writing each expense
        }
        writer.close(); // Close the file to save changes
    }

    // Method to load expenses from a file
    public void loadFromFile(String filename) throws IOException {
        // Create a BufferedReader to read from the specified file
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;

        // Read each line from the file until no more lines are left
        while ((line = reader.readLine()) != null) {
            // Split the line by commas to get expense details
            String[] parts = line.split(",");
            String description = parts[0];
            double amount = Double.parseDouble(parts[1]); // Convert the amount from string to double
            String category = parts[2];

            // Create a new Expense object from the file data and add it to the list
            expenses.add(new Expense(description, amount, category));
        }
        reader.close(); // Close the file after reading
    }
}
