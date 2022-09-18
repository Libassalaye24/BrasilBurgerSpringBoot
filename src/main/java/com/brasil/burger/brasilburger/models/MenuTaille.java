package com.brasil.burger.brasilburger.models;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class MenuTaille {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer quantite;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "menu" , referencedColumnName = "id")
    private Menu menu;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "taille" , referencedColumnName = "id")
    private Taille taille;
    
}
