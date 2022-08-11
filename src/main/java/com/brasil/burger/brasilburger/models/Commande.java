package com.brasil.burger.brasilburger.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Commande {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private Date date;
    private Integer montant;
    private String etat;

    @OneToMany(mappedBy = "commande")
    private List<CommandeBurgers> commandeBurgers = new ArrayList<>();

    @OneToMany(mappedBy = "commande")
    private List<CommandeMenus> commandeMenus = new ArrayList<>();

    @OneToMany(mappedBy = "commande")
    private List<CommandeFrites> commandeFrites = new ArrayList<>();

    @OneToMany(mappedBy = "commande")
    private List<CommandeBoissons> commandeBoissons = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "client" , referencedColumnName = "id")
    private Client client;

    @ManyToOne()
    @JoinColumn(name = "paiement" , referencedColumnName = "id")
    private Paiement paiement;

    @ManyToOne()
    @JoinColumn(name = "adresseL" , referencedColumnName = "id")
    private AdresseL adresseL;
  
}
