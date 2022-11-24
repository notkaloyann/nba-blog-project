package com.example.ownwebsite.models.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {



    private Long id;

    public BaseEntity() {
    }

    @Id
    @Column(name = "id",unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
