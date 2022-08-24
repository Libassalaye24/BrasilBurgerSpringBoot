package com.brasil.burger.brasilburger.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class MenusBurgers {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne()
    @JoinColumn(name = "burger", referencedColumnName = "id")
    private Burger burger;

    private Integer quantite;

    @ManyToOne()
    @JoinColumn(name = "menu", referencedColumnName = "id")
    private Menu menu;
}