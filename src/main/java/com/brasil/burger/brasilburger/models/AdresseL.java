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
public class AdresseL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer telephone;
    private String quartier;

    @ManyToOne()
    @JoinColumn(name = "zone" , referencedColumnName = "id")
    private Zone zone;

}
