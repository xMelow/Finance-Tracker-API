package org.acme.DTO;

public class MonthlySpending {
    private String month;
    private int monthNumber;
    private double total;

    public MonthlySpending(String month, int monthNumber, double total) {
        this.month = month;
        this.monthNumber = monthNumber;
        this.total = total;
    }

    public String getMonth() {
        return this.month;
    }

    public int getMonthNumber() {
        return this.monthNumber;
    }

    public double getTotal() {
        return this.total;
    }
}
