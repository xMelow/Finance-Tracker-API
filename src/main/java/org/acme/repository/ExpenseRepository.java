package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.acme.domain.Entity.*;

@ApplicationScoped
public class ExpenseRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Expense> getAll() {
        return entityManager.createQuery("SELECT * FROM Expenses", Expense.class).getResultList();
    }

    public Expense findById(Long id) {
        return entityManager.find(Expense.class, id);
    }
    
    @Transactional
    public void persist(Expense expense) {
        entityManager.persist(expense);
    }

    @Transactional
    public void update(Expense expense) {
        return entityManager.merge(expense);
    }

    @Transactional
    public void create(Expense expense) {
        return entityManager.create(expense);
    }

    @Transactional
    public void delete(long id) {
        Expense expense = findById(id);
        if (expense != null) {
            entityManager.remove(expense);
        }
    }
}
