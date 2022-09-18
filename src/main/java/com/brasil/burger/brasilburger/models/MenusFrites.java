package com.brasil.burger.brasilburger.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class MenusFrites {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "menu" , referencedColumnName = "id")
    private Menu menu;

    private Integer quantite;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "frite" , referencedColumnName = "id")
    private Frite frite;
}
