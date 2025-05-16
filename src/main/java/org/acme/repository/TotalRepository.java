package org.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class TotalRepository {
    
    @PersistenceContext
    EntityManager entityManager;
}
