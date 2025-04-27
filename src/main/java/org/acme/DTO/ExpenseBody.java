package org.acme.DTO;

import java.time.LocalDate;
import java.util.Locale.Category;

public class ExpenseBody {
    
    private double amount;
    private Category category;
    private String description;
    private LocalDate date;

    public double getAmount() {
        return this.amount;
    }

    public Category getCategory() {
        return this.category;
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

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
