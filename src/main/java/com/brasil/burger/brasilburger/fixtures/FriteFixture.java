package com.brasil.burger.brasilburger.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brasil.burger.brasilburger.models.Frite;
import com.brasil.burger.brasilburger.services.ComplementsService;

@Component
public class FriteFixture {
    @Autowired
    private ComplementsService complementsService;

    public void run(){
        for (int index = 1; index < 10; index++) {
            Frite frite = new Frite();
            frite.setImage("image.png");
            frite.setLibelle("frite"+index);
            frite.setPrix(500+index);
            frite.setQuantiteStock("10");
            complementsService.addFrite(frite);
        }
    }

}
