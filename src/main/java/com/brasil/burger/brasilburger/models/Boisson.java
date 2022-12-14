package com.brasil.burger.brasilburger.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Boisson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantiteStock;


    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "marque" , referencedColumnName = "id")
    private Marque marque;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "taille" , referencedColumnName = "id")
    private Taille taille;

    private String type;
    private String image;
    private String libelle;
    private Boolean etat;

    @OneToMany(mappedBy = "boisson")
    private List<CommandeBoissons> commandeBoissons = new ArrayList<>();

}
