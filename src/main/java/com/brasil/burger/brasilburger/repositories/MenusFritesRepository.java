package com.brasil.burger.brasilburger.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasil.burger.brasilburger.models.Menu;
import com.brasil.burger.brasilburger.models.MenusFrites;

public interface MenusFritesRepository extends JpaRepository<MenusFrites , Long>{
    List<MenusFrites> findByMenu(Menu menu);
}
