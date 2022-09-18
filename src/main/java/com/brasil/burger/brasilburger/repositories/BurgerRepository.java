package com.brasil.burger.brasilburger.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brasil.burger.brasilburger.models.Burger;

@Repository
public interface BurgerRepository extends JpaRepository<Burger , Long>{

}
