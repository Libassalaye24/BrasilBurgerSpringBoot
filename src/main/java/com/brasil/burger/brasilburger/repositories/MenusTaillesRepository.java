package com.brasil.burger.brasilburger.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasil.burger.brasilburger.models.Menu;
import com.brasil.burger.brasilburger.models.MenuTaille;

public interface MenusTaillesRepository extends JpaRepository<MenuTaille ,Long>{
    
    List<MenuTaille> findByMenu(Menu menu);
}
