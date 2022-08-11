package com.brasil.burger.brasilburger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasil.burger.brasilburger.models.Menu;

public interface MenuRepository extends JpaRepository<Menu , Long>{
    
}
