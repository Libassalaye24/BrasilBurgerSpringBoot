package com.brasil.burger.brasilburger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasil.burger.brasilburger.models.Marque;

public interface MarqueRepository extends JpaRepository<Marque , Long>{
    
}
