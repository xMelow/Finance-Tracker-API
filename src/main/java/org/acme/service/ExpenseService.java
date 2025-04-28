package org.acme.service;

import java.util.List;

import org.acme.DTO.ExpenseBody;
import org.acme.domain.Entity.Expense;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExpenseService {
    
    private List<Expense> expenses;
    private int id;

    public ExpenseService() {

    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public Expense getExpenseById(int id) {
        return expenses.get(id);
    }

    public String addExpense(ExpenseBody body) {
        // try catch
        //get body data
        
        Expense expense = new Expense(id, body.getAmount(), body.getCategory(), body.getDescription(), body.getDate());
        this.id += 1;

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
