package com.brasil.burger.brasilburger.models;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class MenuTaille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantite;

    @ManyToOne()
    @JoinColumn(name = "menu" , referencedColumnName = "id")
    private Menu menu;

    @ManyToOne()
    @JoinColumn(name = "taille" , referencedColumnName = "id")
    private Taille taille;
    
}
