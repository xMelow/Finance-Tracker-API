package org.acme.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId")
    private int id;

    @Column(name = "Name")
    private String name;

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public int getId() { return this.id; }
    
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
}
