package com.brasil.burger.brasilburger.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brasil.burger.brasilburger.models.Burger;
import com.brasil.burger.brasilburger.services.FoodService;
@Component
public class BurgerFixture {

    @Autowired
    private  FoodService foodService;

    
     
    public void run(){
   
        for(int i=3; i<=10; i++) {
            Burger burger = new Burger();
            burger.setDescription("description burger"+i);
            burger.setNom("burger"+i);
            burger.setType("burger");
            burger.setImage("image1.png");
            foodService.addBurger(burger);
        }
    }
}
