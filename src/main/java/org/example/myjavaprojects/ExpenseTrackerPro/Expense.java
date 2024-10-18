package org.example.myjavaprojects.ExpenseTrackerPro;

// Class representing an expense with a description, amount, and category
public class Expense {
    private String description; // The name or detail of the expense (what was purchased)
    private double amount; // The cost associated with the expense
    private String category; // The category this expense falls under (e.g., Food, Transport)

    // Constructor to initialize an expense object
    public Expense(String description, double amount, String category) {
        // Assign the parameters to the instance variables
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    // Getter method for the expense description
    public String getDescription() {
        return description; // Returning the description so we can access it outside the class
    }

    // Getter method for the expense amount
    public double getAmount() {
        return amount; // Returning the amount of the expense
    }

    // Getter method for the expense category
    public String getCategory() {
        return category; // Returning the category of the expense
    }

    // Overriding the toString() method to provide a custom string representation of an expense
    @Override
    public String toString() {
        // Return a formatted string combining all the expense details
        return "Description: " + description + ", Amount: " + amount + ", Category: " + category;
    }
}
