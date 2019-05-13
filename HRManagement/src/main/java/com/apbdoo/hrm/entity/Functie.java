package com.apbdoo.hrm.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Functie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}