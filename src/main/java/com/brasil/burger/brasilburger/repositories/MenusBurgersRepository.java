package com.brasil.burger.brasilburger.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasil.burger.brasilburger.models.Menu;
import com.brasil.burger.brasilburger.models.MenusBurgers;

public interface MenusBurgersRepository extends JpaRepository<MenusBurgers , Long>{
    List<MenusBurgers> findByMenu(Menu menu);
}
