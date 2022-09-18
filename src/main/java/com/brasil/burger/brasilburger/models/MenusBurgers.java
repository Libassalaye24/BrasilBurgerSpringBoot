package com.brasil.burger.brasilburger.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;


@Entity
@Data
public class MenusBurgers {
    
    @Id
    @GeneratedValue()
    private Long id;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "burger", referencedColumnName = "id")
    public Burger burger;

    private Integer quantite;

    @JsonManagedReference
    @ManyToOne()
    @JoinColumn(name = "menu", referencedColumnName = "id")
    private Menu menu;

    @Override
    public String toString() {
        return "MenusBurgers [burger=" + burger + ", id=" + id + ", menu=" + menu + ", quantite=" + quantite + "]";
    }
   
    
}
