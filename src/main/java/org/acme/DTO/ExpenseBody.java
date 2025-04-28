package org.acme.DTO;

import java.time.LocalDate;

public class ExpenseBody {
    
    private int expenseId;
    private double amount;
    private int categoryId;
    private String description;
    private LocalDate date;

    public int getExpenseId() {
        return this.expenseId;
    }

    public double getAmount() {
        return this.amount;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
