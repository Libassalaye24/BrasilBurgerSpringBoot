package com.brasil.burger.brasilburger.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.brasil.burger.brasilburger.models.Burger;
import com.brasil.burger.brasilburger.models.Menu;
import com.brasil.burger.brasilburger.services.FoodService;

@Controller
public class CatalogueController {
    @Autowired
    private FoodService foodService;
    
    @GetMapping({"/","/catalogue"})
    public String viewCatalogue(Model model){
        List<Burger> foods = foodService.findAllBurgers();
        model.addAttribute("foods", foods);
        return "catalogue/home";
    }

    @GetMapping("/catalogue/details/{id}")
    public String viewDetails(@PathVariable Long id , Model model){
        Burger burger = foodService.findBurgerById(id);
        if (burger != null) {
            model.addAttribute("burger" , burger);
            return "catalogue/details";
        }else{
            model.addAttribute("erreurBurger" , "Burger avec l'id "+id+" est introuvable");
            return "catalogue/erreur";
        }
       
    }

   /*  @GetMapping("/catalogue/type/{type}")
    public String viewCatalogueByType(@PathVariable String type , Model model){
       if (type == "menu") {
            List<Menu> foods = foodService.findAllMenus();
            model.addAttribute("foods", foods);
       }else if(type == "burger"){
            List<Burger> foods = foodService.findAllBurgers();
            model.addAttribute("foods", foods);
       }
       return "catalogue/home";
     
    } */
    @GetMapping("/catalogue/type/{type}")
    public ResponseEntity<?> getCatalogueByJson(@PathVariable String type ){
        Map<String ,String> map = new HashMap<>();
        map.put("url", "/catalogue");
        map.put("type" , type);
        return ResponseEntity.ok(map);
     
    }

    
}
