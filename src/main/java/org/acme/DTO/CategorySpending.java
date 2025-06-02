package org.acme.DTO;

import org.acme.domain.entity.Category;

public class CategorySpending {
    private Category category;
    private double total;

    public CategorySpending(Category category, double total) {
        this.category = category;
        this.total = total;
    }

    public Category getCategory() {
        return this.category;
    }

    public double getTotal() {
        return this.total;
    }
}
