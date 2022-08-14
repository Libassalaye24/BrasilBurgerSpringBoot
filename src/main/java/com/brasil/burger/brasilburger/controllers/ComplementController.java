package com.brasil.burger.brasilburger.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.brasil.burger.brasilburger.models.Boisson;
import com.brasil.burger.brasilburger.models.Frite;
import com.brasil.burger.brasilburger.models.Marque;
import com.brasil.burger.brasilburger.models.Taille;
import com.brasil.burger.brasilburger.services.ComplementsService;

@Controller
public class ComplementController {
    @Autowired
    private ComplementsService complementService;

    @GetMapping("/complement-add")
    public String viewAddComplement(Model model) {
        List<Marque> marques = complementService.findAllMarques();
        List<Taille> tailles = complementService.findAllTailles();
        Boisson boisson = new Boisson();
        Frite frite = new Frite();
        model.addAttribute("boisson", boisson);
        model.addAttribute("frite", frite);
        model.addAttribute("tailles", tailles);
        model.addAttribute("marques", marques);
        return "complement/add";
    }

    @PostMapping("/complement-add")
    public String addComplement(@ModelAttribute("boisson") Boisson boisson,@RequestParam("file") MultipartFile file) throws IOException {
                System.out.println(" file = " + file);
                System.out.println(" ======");
                System.out.println(boisson.getImage());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
      
        ///
        String uploadDir = "src/main/resources/static/img/uploads/" + fileName;
        //Path uploadPath = Paths.get(uploadDir);
        boisson.setType("boisson");
        boisson.setImage(fileName);
        complementService.addBoisson(boisson);
        ComplementsService.saveFile(uploadDir, fileName, file);
        //
        return "redirect:/complement-liste";
    }

    @GetMapping("/complement-liste")
    public String complementListe(Model model) {

        List<Boisson> boissons = complementService.findAllBoissons();
        List<Frite> frites = complementService.findAllFrites();
        model.addAttribute("boissons", boissons);
        model.addAttribute("frites", frites);

        return "complement/liste";
    }

}
