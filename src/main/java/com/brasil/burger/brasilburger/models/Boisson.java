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

import lombok.Data;

@Entity
@Data
public class Boisson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantiteStock;
    @ManyToOne
    @JoinColumn(name = "marque" , referencedColumnName = "id")
    private Marque marque;

    @ManyToOne
    @JoinColumn(name = "taille" , referencedColumnName = "id")
    private Taille taille;

    @OneToMany(mappedBy = "boisson")
    private List<CommandeBoissons> commandeBoissons = new ArrayList<>();

}
