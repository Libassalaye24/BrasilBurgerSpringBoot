package com.brasil.burger.brasilburger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasil.burger.brasilburger.models.Boisson;

public interface BoissonRepository extends JpaRepository<Boisson , Long>{
    
}
