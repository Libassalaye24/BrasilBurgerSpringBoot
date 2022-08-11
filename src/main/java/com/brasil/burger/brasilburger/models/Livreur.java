package com.brasil.burger.brasilburger.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("livreur")
public class Livreur extends User{
    private String matriculeMoto;
    private Integer telephone;
}
