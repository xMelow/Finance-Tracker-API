package org.acme.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.DTO.CategorySpending;
import org.acme.DTO.MonthlySpending;
import org.acme.domain.entity.Category;

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

   public List<CategorySpending> getTotalSpendingPerCategory() {
        List<Object[]> results = entityManager.createQuery("SELECT c, SUM(e.amount) FROM Expense e JOIN Category c ON e.categoryId = c.id GROUP BY c", Object[].class).getResultList();

        return results.stream()
            .map(row -> new CategorySpending(
                (Category) row[0],
                row[1] != null ? ((Number) row[1]).doubleValue() : 0.0
            ))
            .collect(Collectors.toList());
    }
}
