package com.brasil.burger.brasilburger.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brasil.burger.brasilburger.models.Burger;
import com.brasil.burger.brasilburger.models.Menu;
import com.brasil.burger.brasilburger.repositories.BurgerRepository;
import com.brasil.burger.brasilburger.repositories.MenuRepository;

import lombok.extern.java.Log;

@Service
@Log
public class FoodService {
    @Autowired
    private BurgerRepository burgerRepository;

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> findAllMenus(){
        return menuRepository.findAll();
    }
    public List<Burger> findAllBurgers(){
        return burgerRepository.findAll();
    }

    public Burger findBurgerById(Long id){
       return burgerRepository.findById(id).orElse(null);
    }
    public Menu findMenuById(Long id){
        return menuRepository.findById(id).orElse(null);
    }

    public Burger addBurger(Burger burger){
        try {
            burgerRepository.save(burger);
            return burger;
        } catch (Exception e) {
           log.severe(e.getLocalizedMessage());
           throw e;
        }
       
    }
    public Menu addMenu(Menu menu){
        try {
            menuRepository.save(menu);
            return menu;
        } catch (Exception e) {
           log.severe(e.getLocalizedMessage());
           throw e;
        }
       
    }
   
}
