package org.acme.service;

import java.util.List;

import org.acme.DTO.ExpenseBody;
import org.acme.domain.Entity.Expense;
import org.acme.repository.ExpenseRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ExpenseService {
    
    @Inject
    ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.getAll();
    }

    public Expense getExpenseById(long id) {
        return expenseRepository.findById(id);
    }

    public void addExpense(ExpenseBody body) {
        Expense expense = new Expense(body.getAmount(), body.getCategoryId(), body.getDescription(), body.getDate());
        expenseRepository.create(expense);    
    }

    public void updateExpense(ExpenseBody body) {
        Expense expense = getExpenseById(body.getExpenseId());
        Expense updatedExpense = updateExpenseData(expense, body);
        expenseRepository.update(updatedExpense);
    }

    private Expense updateExpenseData(Expense expense, ExpenseBody body) {
        expense.setAmount(body.getAmount());
        expense.setCategoryId(body.getCategoryId());
        expense.setDate(body.getDate());
        expense.setDescription(body.getDescription());
        return expense;
    }


    public void removeExpense(long id) {
        expenseRepository.delete(id);
    }
}
