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

    public Expense getExpenseById(int id) {
        return expenses.get(id);
    }

    public String addExpense() {
        // try catch
        //get body data
        Expense expense = new Expense(0, 0, null, null, null);
        expenses.add(expense);
        return "Expense added";
    }

    public String removeExpense(int id) {
        // try catch
        Expense expense = getExpenseById(id);
        expenses.remove(expense);
        return "Expense removed";
    }
}
