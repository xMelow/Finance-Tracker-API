package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import jakarta.persistence.criteria.*;
import java.util.ArrayList;
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
    public Expense delete(int id) {
        Expense expense = findById(id);
        if (expense != null) {
            entityManager.remove(expense);
        }
        return expense;
    }

   public List<Expense> findFilteredExpenses(Integer categoryId, Double minAmount, Double maxAmount, String search) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Expense> cq = cb.createQuery(Expense.class);
        Root<Expense> expense = cq.from(Expense.class);
        List<Predicate> predicates = new ArrayList<>();

        if (categoryId != null) {
            predicates.add(cb.equal(expense.get("categoryId"), categoryId));
        }

        if (minAmount != null && minAmount > 0) {
            predicates.add(cb.ge(expense.get("amount"), minAmount));
        }

        if (maxAmount != null && maxAmount > 0) {
            predicates.add(cb.le(expense.get("amount"), maxAmount));
        }

        if (search != null && !search.isBlank()) {
            predicates.add(cb.like(cb.lower(expense.get("description")), "%" + search.toLowerCase() + "%"));
        }

        cq.where(cb.and(predicates.toArray(new Predicate[0])));
        cq.orderBy(cb.desc(expense.get("date")));

        TypedQuery<Expense> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

}
