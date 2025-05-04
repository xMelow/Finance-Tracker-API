package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

import org.acme.domain.entity.*;

@ApplicationScoped
public class ExpenseRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Expense> getAll() {
        return entityManager.createQuery("SELECT e FROM Expense e", Expense.class).getResultList();
    }

    public Expense findById(int id) {
        return entityManager.find(Expense.class, id);
    }
    
    @Transactional
    public Expense create(Expense expense) {
        entityManager.persist(expense);
        return expense;
    }

    @Transactional
    public Expense update(int id, Expense expense) {
        return entityManager.merge(expense);
    }

    @Transactional
    public void delete(int id) {
        Expense expense = findById(id);
        if (expense != null) {
            entityManager.remove(expense);
        }
    }
}
