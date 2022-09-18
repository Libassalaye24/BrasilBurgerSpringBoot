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
public class CommandeBurgers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer quantite;

    @ManyToOne()
    @JoinColumn(name = "commande" , referencedColumnName = "id")
    private Commande commande;

    @ManyToOne()
    @JoinColumn(name = "burger" , referencedColumnName = "id")
    private Burger burger;
}
