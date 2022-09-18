package com.brasil.burger.brasilburger.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class Taille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String libelle;
    private Integer prix;

    @JsonBackReference
    @OneToMany(mappedBy = "taille")
    private List<Boisson> boissons;

    @JsonBackReference
    @OneToMany(mappedBy = "taille")
    private List<MenuTaille> menuTailles = new ArrayList<>();

    private String image;
    private String type;
    
}
