package com.brasil.burger.brasilburger.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.brasil.burger.brasilburger.models.Burger;
import com.brasil.burger.brasilburger.models.Frite;
import com.brasil.burger.brasilburger.models.Menu;
import com.brasil.burger.brasilburger.models.MenuTaille;
import com.brasil.burger.brasilburger.models.MenusBurgers;
import com.brasil.burger.brasilburger.models.MenusFrites;
import com.brasil.burger.brasilburger.models.Taille;
import com.brasil.burger.brasilburger.models.User;
import com.brasil.burger.brasilburger.services.ComplementsService;
import com.brasil.burger.brasilburger.services.FoodService;
import com.brasil.burger.brasilburger.services.UserService;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private ComplementsService complementService;
    @Autowired
    private UserService userService;

    @GetMapping("/food-liste")
    public String listBurgers(){
       /*  List<Menu> menus = foodService.findAllMenus();
        List<Burger> burgers = foodService.findAllBurgers();
        model.addAttribute("menus",menus);
        model.addAttribute("burgers",burgers); */
        return "foods/liste";
    }

    public void getConectted(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        String role = user.getRole().getLibelle();
        
    }

 

    @GetMapping("/food-add")
    public String viewAddFood(Model model){
        Menu menu = new Menu();
        Burger burger = new Burger();
        List<Taille> tailles = complementService.findAllTailles();
        List<Burger> burgers = foodService.findAllBurgers();
        List<Frite> frites = complementService.findAllFrites();
        model.addAttribute("menu",menu);
        model.addAttribute("burger",burger);
        model.addAttribute("tailles", tailles);
        model.addAttribute("burgers",burgers);
        model.addAttribute("frites",frites);
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

    public static Long getNbr(String str) 
    { 
        // Remplacer chaque nombre non numérique par un vide
        str = str.replaceAll("[^\\d]", ""); 
        // Supprimer les espaces de début et de fin 
        str = str.trim(); 

        return Long.parseLong(str);
    } 
  
    @PostMapping("/menu-add")
    public String addMenu(@ModelAttribute("menu") Menu menu, @RequestParam("file") MultipartFile file ,
                             @RequestParam(value = "quantiteBurger[]" , required = false) List<String> quantiteBurger ,
                             @RequestParam(value = "quantiteTaille[]" , required = false) List<String> quantiteTaille ,
                             @RequestParam(value = "quantiteFrite[]" , required = false) List<String> quantiteFrite) throws IOException{

        
       // String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Long fileName = ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
       
        String uploadDir = "src/main/resources/static/img/uploads/" + fileName;
        menu.setImage(fileName.toString());

        /* add menu  */        
        Menu menuAdd = foodService.addMenu(menu);
        /* fin add menu */

        /* parcourir le tableau de quantite Burger et instancier des objets de menusBurgers */
            if (quantiteBurger.size() > 0) {
                for (String index : quantiteBurger) {
                    String[] stringBurger = index.split("-");
                    Integer qb = Integer.parseInt(stringBurger[1]);
                    if (qb != 0) {
                        Long idBurger = getNbr(stringBurger[0]);
                        Burger burgerMenu = foodService.findBurgerById(idBurger);
                        MenusBurgers menusBurgers = new MenusBurgers();
                        menusBurgers.setMenu(menuAdd);
                        menusBurgers.setBurger(burgerMenu);
                        menusBurgers.setQuantite(qb);
                        foodService.addMenuBurger(menusBurgers);
                    }
                }
            }
        /* fin parcours tableau de MenuBurger */
        
        /* parcourir le tableau de quantite taille et instancier des menusTailles  */
            if (quantiteTaille.size() > 0) {
                for (String index : quantiteTaille) {
                    String[] stringTaille = index.split("-");
                    Integer qt = Integer.parseInt(stringTaille[1]);
                    if (qt != 0) {
                        Long idTaille = getNbr(stringTaille[0]);
                        Taille tailleOnAdd = complementService.findTailleById(idTaille);
                        MenuTaille menuTaille = new MenuTaille();
                        menuTaille.setMenu(menuAdd);
                        menuTaille.setQuantite(qt);
                        menuTaille.setTaille(tailleOnAdd);
                        foodService.addMenuTaille(menuTaille);
                    }
                }
            }
        /* Fin parcours tableau de MenuTaille */

        /* parcourir le tableau de quantite Frite et instancier des menusFrites  */
            if (quantiteFrite.size() > 0) {
                for (String index : quantiteFrite) {
                    String[] stringFrite = index.split("-");
                    Integer qf = Integer.parseInt(stringFrite[1]);
                    if (qf != 0) {
                        Long idFrite = getNbr(stringFrite[0]);
                        Frite friteOnAdd = complementService.findFriteById(idFrite);
                        MenusFrites menusFrites = new MenusFrites();
                        menusFrites.setMenu(menuAdd);
                        menusFrites.setQuantite(qf);
                        menusFrites.setFrite(friteOnAdd);
                        foodService.addMenuFrite(menusFrites);
                    }
                }
            }
        /* Fin parcours tableau de MenuFrite */

        ComplementsService.saveFile(uploadDir, fileName.toString(), file);
        return "redirect:/food-liste";
    }
    
}
