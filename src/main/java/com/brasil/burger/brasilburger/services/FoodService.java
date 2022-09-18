package com.brasil.burger.brasilburger.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brasil.burger.brasilburger.models.Boisson;
import com.brasil.burger.brasilburger.models.Burger;
import com.brasil.burger.brasilburger.models.Frite;
import com.brasil.burger.brasilburger.models.Menu;
import com.brasil.burger.brasilburger.models.MenuTaille;
import com.brasil.burger.brasilburger.models.MenusBurgers;
import com.brasil.burger.brasilburger.models.MenusFrites;
import com.brasil.burger.brasilburger.repositories.BoissonPaginatedRepository;
import com.brasil.burger.brasilburger.repositories.BurgerPaginatedRepository;
import com.brasil.burger.brasilburger.repositories.BurgerRepository;
import com.brasil.burger.brasilburger.repositories.FritePaginatedRepository;
import com.brasil.burger.brasilburger.repositories.MenuPaginatedRepository;
import com.brasil.burger.brasilburger.repositories.MenuRepository;
import com.brasil.burger.brasilburger.repositories.MenusBurgersRepository;
import com.brasil.burger.brasilburger.repositories.MenusFritesRepository;
import com.brasil.burger.brasilburger.repositories.MenusTaillesRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import lombok.extern.java.Log;

@Service
@Log
public class FoodService {
    @Autowired
    private BurgerRepository burgerRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private BurgerPaginatedRepository burgerPaginatedRepository;

    @Autowired
    private MenuPaginatedRepository menuPaginatedRepository;

    @Autowired
    private BoissonPaginatedRepository boissonPaginatedRepository;

    @Autowired
    private FritePaginatedRepository fritePaginatedRepository;

    @Autowired
    private MenusBurgersRepository menusBurgersRepository;

    @Autowired
    private MenusTaillesRepository menusTaillesRepository;

    @Autowired
    private MenusFritesRepository menusFritesRepository;

    public List<Menu> findAllMenus(){
        return menuRepository.findAll();
    }
    public List<Burger> findAllBurgers(){
        return burgerRepository.findAll();
    }
    public Page<Burger> findAllBurgersPaginated(int pageNo , int pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Burger> pageResult = burgerPaginatedRepository.findAll(paging);
        return pageResult;
    }
    public Page<Boisson> findAllBoissonsPaginated(int pageNo , int pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Boisson> pageResult = boissonPaginatedRepository.findAll(paging);
        return pageResult;
    }
    public Page<Frite> findAllFritesPaginated(int pageNo , int pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Frite> pageResult = fritePaginatedRepository.findByEtat(false,paging);
        return pageResult;
    }
    public Page<Menu> findAllMenusPaginated(int pageNo , int pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Menu> pageResult = menuPaginatedRepository.findAll(paging);
        return pageResult;
    }
    public List<MenusBurgers> findAllMenuBurgers(){
        return menusBurgersRepository.findAll();
    }
    public List<MenusFrites> findAllMenuFrites(){
        return menusFritesRepository.findAll();
    }
    public List<MenuTaille> findAllMenuTailles(){
        return menusTaillesRepository.findAll();
    }
    public List<MenusFrites> findAllMenuFritesByMenu(Menu menu){
        return menusFritesRepository.findByMenu(menu);
    }
    public List<MenusBurgers> findAllMenuBurgersByMenu(Menu menu){
        return menusBurgersRepository.findByMenu(menu);
    }
    public List<MenuTaille> findAllMenuTaillesByMenu(Menu menu){
        return menusTaillesRepository.findByMenu(menu);
    }
   /*  public List<Burger> listeBurgers(){
        return burgerRepository.findAllBurgers();
    } */

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

    public MenusBurgers addMenuBurger(MenusBurgers menuB){
        try {
            menusBurgersRepository.save(menuB);
            return menuB;
        } catch (Exception e) {
           log.severe(e.getLocalizedMessage());
           throw e;
        }
       
    }

    public MenuTaille addMenuTaille(MenuTaille menuT){
        try {
            menusTaillesRepository.save(menuT);
            return menuT;
        } catch (Exception e) {
           log.severe(e.getLocalizedMessage());
           throw e;
        }
       
    }

    public MenusFrites addMenuFrite(MenusFrites menuF){
        try {
            menusFritesRepository.save(menuF);
            return menuF;
        } catch (Exception e) {
           log.severe(e.getLocalizedMessage());
           throw e;
        }
       
    }


   
}
