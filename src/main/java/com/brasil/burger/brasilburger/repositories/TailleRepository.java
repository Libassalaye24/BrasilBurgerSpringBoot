package com.brasil.burger.brasilburger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasil.burger.brasilburger.models.Taille;

public interface TailleRepository extends JpaRepository<Taille , Long>{
    
}
