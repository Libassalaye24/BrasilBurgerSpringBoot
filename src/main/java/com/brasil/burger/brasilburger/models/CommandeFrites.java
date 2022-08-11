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
public class CommandeFrites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantite;

    @ManyToOne()
    @JoinColumn(name = "commande" , referencedColumnName = "id")
    private Commande commande;
    
    @ManyToOne()
    @JoinColumn(name = "frite" , referencedColumnName = "id")
    private Frite frite;
}
