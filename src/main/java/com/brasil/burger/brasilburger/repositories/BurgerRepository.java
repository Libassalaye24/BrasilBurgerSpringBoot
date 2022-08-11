package com.brasil.burger.brasilburger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasil.burger.brasilburger.models.Burger;

public interface BurgerRepository extends JpaRepository<Burger , Long>{
    
}
