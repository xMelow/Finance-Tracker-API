package org.acme.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.DTO.MonthlySpending;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class TotalRepository {
    
    @PersistenceContext
    EntityManager entityManager;

    public double getTotalSpending() {
        return (double) entityManager.createQuery("SELECT SUM(e.amount) as expense FROM Expense e").getSingleResult();
    }

    public List<MonthlySpending> getTotalSpendingPerMonth() {
    List<Object[]> results = entityManager.createQuery("SELECT MONTH(e.date), SUM(e.amount) FROM Expense e GROUP BY MONTH(e.date)", Object[].class).getResultList();

    return results.stream()
        .map(row -> new MonthlySpending((Integer) row[0], row[1] != null ? ((Number) row[1]).intValue() : 0))
        .collect(Collectors.toList());
}

}
