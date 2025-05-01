package org.acme.repository;

import org.acme.domain.entity.Category;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CategoryRepository {
    
    @PersistenceContext
    EntityManager entityManager;

    public List<Category> getAll() {
        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    public Category findById(int id) {
        return entityManager.find(Category.class, id);
    }

    public Category findByName(String name) {
        return entityManager.createQuery(
                "SELECT c FROM Category c WHERE c.name = :name", Category.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
