package org.acme.service;

import java.util.List;

import org.acme.repository.TotalRepository;
import org.acme.DTO.CategorySpending;
import org.acme.DTO.MonthlySpending;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TotalService {
    
    @Inject
    TotalRepository totalRepository;

    public double getTotalSpending() {
        return totalRepository.getTotalSpending();
    }

    public List<MonthlySpending> getTotalSpendingPerMonth() {
        return totalRepository.getTotalSpendingPerMonth();
    }

    public List<CategorySpending> getTotalSpendingPerCategory() {
        return totalRepository.getTotalSpendingPerCategory();
    }
}
