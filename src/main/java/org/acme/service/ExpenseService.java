package org.acme.service;

import java.util.List;

import org.acme.domain.Expense;

public class ExpenseService {
    
    private List<Expense> expenses;

    public ExpenseService() {

    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }
}
