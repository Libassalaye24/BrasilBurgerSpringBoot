package com.brasil.burger.brasilburger.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    private Boolean etat;
    
   /*  @ManyToMany
    private List<Menu> menus = new ArrayList<>(); */
    @JsonBackReference
    @OneToMany(mappedBy = "burger")
    public List<MenusBurgers> menusBurgers = new ArrayList<>();

    @Override
    public String toString() {
        return "Burger [description=" + description + ", id=" + id + ", image=" + image + ", menusBurgers="
                + menusBurgers + ", nom=" + nom + ", prix=" + prix + ", type=" + type + "]";
    }


}
