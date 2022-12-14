package com.brasil.burger.brasilburger.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private String description;
    private String type;
    private String image;
    private Integer prix;
    private Boolean etat;

    @JsonBackReference
    @OneToMany(mappedBy = "menu")
    private List<MenusBurgers> menusBurgers = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "menu")
    private List<MenuTaille> menuTailles = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "menu")
    private List<MenusFrites> menuFrites = new ArrayList<>();

    

}
