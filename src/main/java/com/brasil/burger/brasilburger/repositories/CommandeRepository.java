package com.brasil.burger.brasilburger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasil.burger.brasilburger.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande , Long>{
    
}
