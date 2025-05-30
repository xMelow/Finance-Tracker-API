package org.acme.service;

import java.util.List;

import org.acme.DTO.ExpenseBody;
import org.acme.domain.entity.Expense;
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

    public List<Expense> getFilteredExpenses(Integer categoryId, Double minAmount, Double maxAmount, String description) {
        return expenseRepository.findFilteredExpenses(categoryId, minAmount, maxAmount, description);
    }

    public Expense getExpenseById(int id) {
        return expenseRepository.findById(id);
    }

    public Expense addExpense(ExpenseBody body) {
        Expense expense = new Expense(body.getAmount(), body.getCategoryId(), body.getDescription(), body.getDate());
        return expenseRepository.create(expense);    
    }

    public Expense updateExpense(int id, ExpenseBody body) {
        Expense expense = getExpenseById(id);
        Expense updatedExpense = updateExpenseData(expense, body);
        expenseRepository.update(id, updatedExpense);
        return updatedExpense;
    }

    private Expense updateExpenseData(Expense expense, ExpenseBody body) {
        expense.setAmount(body.getAmount());
        expense.setCategoryId(body.getCategoryId());
        expense.setDate(body.getDate());
        expense.setDescription(body.getDescription());
        return expense;
    }


    public Expense removeExpense(int id) {
        return expenseRepository.delete(id);
    }
}
