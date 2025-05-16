package org.acme.service;

import org.acme.repository.TotalRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TotalService {
    
    @Inject
    TotalRepository totalRepository;

    public int getTotalSpending() {
        return totalRepository.getTotalSpending();
    } 
}
