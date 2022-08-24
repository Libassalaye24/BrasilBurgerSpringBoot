package com.brasil.burger.brasilburger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommandeController {
    
    @GetMapping("/panier-list")
    public String viewPanier(){

        return "panier/panier";
    }
}
