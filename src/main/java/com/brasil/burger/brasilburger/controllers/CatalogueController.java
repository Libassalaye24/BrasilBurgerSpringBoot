package com.brasil.burger.brasilburger.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.brasil.burger.brasilburger.models.Boisson;
import com.brasil.burger.brasilburger.models.Burger;
import com.brasil.burger.brasilburger.models.Frite;
import com.brasil.burger.brasilburger.models.Menu;
import com.brasil.burger.brasilburger.models.MenuTaille;
import com.brasil.burger.brasilburger.models.MenusBurgers;
import com.brasil.burger.brasilburger.models.MenusFrites;
import com.brasil.burger.brasilburger.services.ComplementsService;
import com.brasil.burger.brasilburger.services.FoodService;

@Controller
public class CatalogueController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private ComplementsService complementService;

    @GetMapping("/catalogue/burger/{id}")
    public ResponseEntity<?> getOneBurgerJson(@PathVariable Long id) {
        Burger burger = foodService.findBurgerById(id);
        Map<String, Burger> map = new HashMap<>();
        map.put("burger", burger);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/catalogue/menu/{id}")
    public ResponseEntity<?> getOneMenuJson(@PathVariable Long id) {
        Menu menu = foodService.findMenuById(id);
        Menu menu2 = new Menu();
        menu2.setId(menu.getId());
        menu2.setImage(menu.getImage());
        menu2.setDescription(menu.getDescription());
        menu2.setType(menu.getType());
        menu2.setNom(menu.getNom());
        menu2.setPrix(menu.getPrix());
        Map<String, Menu> map = new HashMap<>();
        map.put("menu", menu2);
        return ResponseEntity.ok(map);
    }
    /*
     * @GetMapping("/catalogue/menu")
     * public Class<ResponseEntity> getAllMenus(){
     * List<Menu> menus = foodService.findAllMenus();
     * 
     * Map<String, List<Menu>> map = new HashMap<>();
     * map.put("menus", menus);
     * return ResponseEntity.class;
     * 
     * }
     */

    @GetMapping({ "/", "/catalogue" })
    public String viewCatalogue(Model model, HttpServletRequest request) {

        List<Burger> burgers = foodService.findAllBurgers();
        List<Menu> menus = foodService.findAllMenus();

        model.addAttribute("burgers", burgers);
        model.addAttribute("menus", menus);
        return "catalogue/home";
    }

    @GetMapping("/produit-details-{type}-{id}")
    public String viewDetails(@PathVariable Long id, @PathVariable String type, Model model) {

        if (type.contains("menu")) {
            Menu menu = foodService.findMenuById(id);
           
            List<MenusBurgers> menusBurgers = foodService.findAllMenuBurgersByMenu(menu);
            List<MenusFrites> menusFrites = foodService.findAllMenuFritesByMenu(menu);
            List<MenuTaille> menuTailles = foodService.findAllMenuTaillesByMenu(menu);
            List<Boisson> boissons = complementService.findAllBoissons();
            model.addAttribute("produit", menu);
            model.addAttribute("menusBurgers", menusBurgers);
            model.addAttribute("menusFrites", menusFrites);
            model.addAttribute("boissons", boissons);
        } else if (type.contains("burger")) {
            Burger burger = foodService.findBurgerById(id);
            model.addAttribute("produit", burger);
        }
        return "catalogue/details";

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
