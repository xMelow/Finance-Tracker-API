package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class TotalRepository {
    
    @PersistenceContext
    EntityManager entityManager;

    public int getTotalSpending() {
        return entityManager.createQuery("SELECT SUM(e.amount) as expense FROM Expenses e");

    }

    public int getTotalSpendingPerMonth() {
        return entityManager.createQuery("SELECT MONTH(e.date) AS month, SUM(e.amount) as expense FROM Expenses e GROUP BY MONTH(e.date)");
    }
}
