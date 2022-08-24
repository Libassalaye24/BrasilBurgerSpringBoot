package com.brasil.burger.brasilburger.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Frite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    private String quantiteStock;
    private Integer prix;
    private String image;
    private String type;
    private Boolean etat;
    @OneToMany(mappedBy = "frite")
    private List<CommandeFrites> commandeFrites = new ArrayList<>();

    @OneToMany(mappedBy = "frite")
    private List<MenusFrites> menuTailles = new ArrayList<>();


}
