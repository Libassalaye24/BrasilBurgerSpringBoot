package com.brasil.burger.brasilburger.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.brasil.burger.brasilburger.models.Burger;
import com.brasil.burger.brasilburger.models.Menu;
import com.brasil.burger.brasilburger.models.Taille;
import com.brasil.burger.brasilburger.services.ComplementsService;
import com.brasil.burger.brasilburger.services.FoodService;

@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private ComplementsService complementService;

    @GetMapping("/food-liste")
    public String listBurgers(Model model){
        List<Menu> menus = foodService.findAllMenus();
        List<Burger> burgers = foodService.findAllBurgers();
        model.addAttribute("menus",menus);
        model.addAttribute("burgers",burgers);
        return "foods/index";
    }
  /*   @GetMapping("/foods-liste")
    public String allFoods(Model model){
        List<Menu> menus = foodService.findAllMenus();
        List<Burger> burgers = foodService.findAllBurgers();
        model.addAttribute("menus",menus);
        model.addAttribute("burgers",burgers);
        return "foods/index";
    } */

    @GetMapping("/food-add")
    public String viewAddFood(Model model){
        Menu menu = new Menu();
        Burger burger = new Burger();
        List<Taille> tailles = complementService.findAllTailles();
        List<Burger> burgers = foodService.findAllBurgers();
        model.addAttribute("menu",menu);
        model.addAttribute("burger",burger);
        model.addAttribute("tailles", tailles);
        model.addAttribute("burgers",burgers);
        return "foods/add";
    }

    @PostMapping("/burger-add")
    public String addBurger(@ModelAttribute("burger") Burger burger, @RequestParam("file") MultipartFile file) throws IOException{
                
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ///
        String uploadDir = "src/main/resources/static/img/uploads/" + fileName;
        burger.setImage(fileName);
        foodService.addBurger(burger);
        ComplementsService.saveFile(uploadDir, fileName, file);
        return "redirect:/food-liste";
    }
  
    @PostMapping("/menu-add")
    public String addMenu(@ModelAttribute("menu") Menu menu, @RequestParam("file") MultipartFile file) throws IOException{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ///
        String uploadDir = "src/main/resources/static/img/uploads/" + fileName;
        menu.setImage(fileName);
        foodService.addMenu(menu);
        ComplementsService.saveFile(uploadDir, fileName, file);
        return "redirect:/liste-food";
    }
    
}
