package org.acme.DTO;

public class MonthlySpending {
    private int month;
    private double total;

    public MonthlySpending(int month, double total) {
        this.month = month;
        this.total = total;
    }

    public int getMonth() {
        return this.month;
    }

    public double getTotal() {
        return this.total;
    }
}
