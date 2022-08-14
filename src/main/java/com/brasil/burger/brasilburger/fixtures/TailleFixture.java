package com.brasil.burger.brasilburger.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brasil.burger.brasilburger.models.Taille;
import com.brasil.burger.brasilburger.services.ComplementsService;

@Component
public class TailleFixture {
    @Autowired
    private ComplementsService complementsService;
    public void run(){
        for (int i = 0; i < 10; i++) {
            Taille taille = new Taille();
            taille.setLibelle("taille"+i);
            taille.setPrix(500+i);
            complementsService.addTaille(taille);
        }
    }
}
