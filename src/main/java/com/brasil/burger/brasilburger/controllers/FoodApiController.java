package com.brasil.burger.brasilburger.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brasil.burger.brasilburger.models.Boisson;
import com.brasil.burger.brasilburger.models.Burger;
import com.brasil.burger.brasilburger.models.Frite;
import com.brasil.burger.brasilburger.models.Menu;
import com.brasil.burger.brasilburger.services.FoodService;

@RestController
public class FoodApiController {
    
    @Autowired
    private FoodService foodService;

    @GetMapping("/api/burgers/{page}/{size}")
    public ResponseEntity<Map<String , Object>>  getBurgers(@PathVariable int page , @PathVariable int size){
        Page<Burger> pageResult = foodService.findAllBurgersPaginated(page, size);
        Map<String , Object> response = new HashMap<>();
        response.put("data", pageResult.toList());
        response.put("currentPage", pageResult.getNumber());
        response.put("totalItems", pageResult.getTotalElements());
        response.put("totalPages", pageResult.getTotalPages());
        response.put("type", "burger");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/api/menus/{page}/{size}")
    public ResponseEntity<Map<String , Object>> getMenus(@PathVariable int page , @PathVariable int size){
        Page<Menu> pageResult = foodService.findAllMenusPaginated(page, size);

        Map<String , Object> response = new HashMap<>();
        response.put("data", pageResult.toList());
        response.put("currentPage", pageResult.getNumber());
        response.put("totalItems", pageResult.getTotalElements());
        response.put("totalPages", pageResult.getTotalPages());
        response.put("type", "menu");
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/boissons/{page}/{size}")
    public ResponseEntity<Map<String , Object>> getBoissons(@PathVariable int page , @PathVariable int size){
        Page<Boisson> pageResult = foodService.findAllBoissonsPaginated(page, size);

        Map<String , Object> response = new HashMap<>();
        response.put("data", pageResult.toList());
        response.put("currentPage", pageResult.getNumber());
        response.put("totalItems", pageResult.getTotalElements());
        response.put("totalPages", pageResult.getTotalPages());
        response.put("type", "boisson");
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/frites/{page}/{size}")
    public ResponseEntity<Map<String , Object>> getFrites(@PathVariable int page , @PathVariable int size){
        Page<Frite> pageResult = foodService.findAllFritesPaginated(page, size);

        Map<String , Object> response = new HashMap<>();
        response.put("data", pageResult.toList());
        response.put("currentPage", pageResult.getNumber());
        response.put("totalItems", pageResult.getTotalElements());
        response.put("totalPages", pageResult.getTotalPages());
        response.put("type", "frite");
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
