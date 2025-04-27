package org.acme.domain;

import java.time.LocalDate;
import java.util.Locale.Category;

public class Expense {
    
    private int id;
    private double amount;
    private Category category;
    private String description;
    private LocalDate date;

    public Expense(int id, double amount, Category category, String description, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

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
}
