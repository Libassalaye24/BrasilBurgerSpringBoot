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
public class CommandeFrites {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer quantite;

    @ManyToOne()
    @JoinColumn(name = "commande" , referencedColumnName = "id")
    private Commande commande;
    
    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "frite" , referencedColumnName = "id")
    private Frite frite;
}
