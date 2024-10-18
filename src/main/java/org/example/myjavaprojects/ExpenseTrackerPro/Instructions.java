package org.example.myjavaprojects.ExpenseTrackerPro;

public class Instructions {
}

//
//
//
//        ### **Project Title: Personal Expense Tracker**
//
//        #### **Objective:**
//Build a simple console-based **Expense Tracker** that allows users to add, view, and manage their daily expenses.
//
//#### **Project Features:**
//        1. Add Expense**: Users can enter a description, amount, and category (e.g., Food, Transport, Entertainment).
//        2. View All Expenses**: List all expenses entered by the user.
//        3. View Total Expense by Category**: Calculate and display the total expenses for each category (e.g., total spent on Food).
//        4. **Save Expenses to a File**: Save all expenses to a text file, so they persist between runs.
//5. **Load Expenses from a File**: Load saved expenses from the file when the program starts.
//
//        #### **Key Concepts You’ll Practice:**
//        - **OOP Principles**: Create classes like `Expense`, `ExpenseManager`, etc.
//- **Java Collections Framework**: Use `ArrayList` to store expenses and `HashMap` for categorizing them.
//        - **File Handling**: Use `File`, `FileReader`, and `FileWriter` to save and load expenses from a text file.
//- **Basic Exception Handling**: Handle file I/O exceptions and invalid input gracefully.
//
//        ---
//
//        ### **Step-by-Step Breakdown**
//
//        #### 1. **Define an `Expense` Class**
//        ```java
//public class Expense {
//    private String description;
//    private double amount;
//    private String category;
//
//    public Expense(String description, double amount, String category) {
//        this.description = description;
//        this.amount = amount;
//        this.category = category;
//    }
//
//    public String getDescription() { return description; }
//    public double getAmount() { return amount; }
//    public String getCategory() { return category; }
//
//    @Override
//    public String toString() {
//        return "Description: " + description + ", Amount: " + amount + ", Category: " + category;
//    }
//}
//```
//
//        #### 2. **Create an `ExpenseManager` Class**
//        - **Add methods to manage expenses**: `addExpense()`, `viewExpenses()`, `totalByCategory()`, and methods for file handling.
//
//        ```java
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.io.*;
//
//public class ExpenseManager {
//    private ArrayList<Expense> expenses = new ArrayList<>();
//
//    // Add a new expense
//    public void addExpense(Expense expense) {
//        expenses.add(expense);
//    }
//
//    // View all expenses
//    public void viewExpenses() {
//        for (Expense expense : expenses) {
//            System.out.println(expense);
//        }
//    }
//
//    // Calculate total expense by category
//    public void totalByCategory() {
//        HashMap<String, Double> categoryTotals = new HashMap<>();
//        for (Expense expense : expenses) {
//            categoryTotals.put(expense.getCategory(),
//                    categoryTotals.getOrDefault(expense.getCategory(), 0.0) + expense.getAmount());
//        }
//
//        for (String category : categoryTotals.keySet()) {
//            System.out.println("Category: " + category + ", Total: " + categoryTotals.get(category));
//        }
//    }
//
//    // Save expenses to a file
//    public void saveToFile(String filename) throws IOException {
//        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
//        for (Expense expense : expenses) {
//            writer.write(expense.getDescription() + "," + expense.getAmount() + "," + expense.getCategory());
//            writer.newLine();
//        }
//        writer.close();
//    }
//
//    // Load expenses from a file
//    public void loadFromFile(String filename) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader(filename));
//        String line;
//        while ((line = reader.readLine()) != null) {
//            String[] parts = line.split(",");
//            String description = parts[0];
//            double amount = Double.parseDouble(parts[1]);
//            String category = parts[2];
//            expenses.add(new Expense(description, amount, category));
//        }
//        reader.close();
//    }
//}
//```
//
//        #### 3. **Main Class (ExpenseTracker)**
//
//        ```java
//import java.util.Scanner;
//
//public class ExpenseTracker {
//
//    public static void main(String[] args) {
//        ExpenseManager manager = new ExpenseManager();
//        Scanner scanner = new Scanner(System.in);
//        boolean running = true;
//
//        // Load existing expenses from file (if any)
//        try {
//            manager.loadFromFile("expenses.txt");
//        } catch (Exception e) {
//            System.out.println("No previous expenses found.");
//        }
//
//        while (running) {
//            System.out.println("1. Add Expense\n2. View Expenses\n3. View Total by Category\n4. Save and Exit");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    System.out.println("Enter description:");
//                    String description = scanner.nextLine();
//                    System.out.println("Enter amount:");
//                    double amount = scanner.nextDouble();
//                    scanner.nextLine(); // Consume newline
//                    System.out.println("Enter category:");
//                    String category = scanner.nextLine();
//                    manager.addExpense(new Expense(description, amount, category));
//                    break;
//                case 2:
//                    manager.viewExpenses();
//                    break;
//                case 3:
//                    manager.totalByCategory();
//                    break;
//                case 4:
//                    try {
//                        manager.saveToFile("expenses.txt");
//                        System.out.println("Expenses saved. Exiting...");
//                    } catch (Exception e) {
//                        System.out.println("Error saving expenses.");
//                    }
//                    running = false;
//                    break;
//                default:
//                    System.out.println("Invalid choice. Try again.");
//            }
//        }
//        scanner.close();
//    }
//}
//```
//
//        ### **Next Steps:**
//        - **Add error handling**: Validate inputs for amount (ensure it’s a number) and category (ensure it’s a non-empty string).
//        - **Enhance the UI**: You can eventually expand this into a **GUI application** using JavaFX to practice Java GUI development.
//- **Explore additional features**: Add expense sorting (by amount or date), create monthly reports, or export data as a CSV file.
//
//This project will give you a **solid foundation** in OOP, file handling, and basic Java utilities while being simple enough to finish quickly. Would you like guidance on any specific part?