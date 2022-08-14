package com.brasil.burger.brasilburger.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.http.HttpRequest;
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

    @GetMapping({ "/", "/catalogue" })
    public String viewCatalogue(Model model, HttpServletRequest request) {
        // System.out.println(request.getSession().getAttribute("type"));

        List<Burger> foods = foodService.findAllBurgers();
        List<Burger> burgers = foodService.findAllBurgers();
        List<Menu> menus = foodService.findAllMenus();

        model.addAttribute("allFoods", foods);
        model.addAttribute("menus", menus);
        model.addAttribute("burgers", burgers);

        String type = (String) request.getSession().getAttribute("type");
        request.getSession().removeAttribute("type");
        model.addAttribute("typeSelected", type);

        return "catalogue/home";
    }

    @GetMapping("/catalogue/details/{id}")
    public String viewDetails(@PathVariable Long id, Model model) {
        Burger burger = foodService.findBurgerById(id);
        if (burger != null) {
            model.addAttribute("burger", burger);
            return "catalogue/details";
        } else {
            model.addAttribute("erreurBurger", "Burger avec l'id " + id + " est introuvable");
            return "catalogue/erreur";
        }

    }

    @GetMapping("/catalogue/type/{type}")
    public String viewCatalogueByType(@PathVariable String type,
            HttpServletRequest request) {
        request.getSession().setAttribute("type", type);

        return "redirect:/catalogue";

    }

    /*
     * @GetMapping("/catalogue/type/{type}")
     * public ResponseEntity<?> getCatalogueByJson(@PathVariable String type,
     * HttpServletRequest request) {
     * Map<String, String> map = new HashMap<>();
     * map.put("url", "/");
     * map.put("type", type);
     * request.getSession().setAttribute("type", type);
     * return ResponseEntity.ok(map);
     * 
     * }
     */

}
