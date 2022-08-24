package com.brasil.burger.brasilburger.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private String type;
    private String image;
    private Integer prix;
    
   /*  @ManyToMany
    private List<Menu> menus = new ArrayList<>(); */

    @OneToMany(mappedBy = "burger")
    private List<MenusBurgers> menusBurgers = new ArrayList<>();


}
