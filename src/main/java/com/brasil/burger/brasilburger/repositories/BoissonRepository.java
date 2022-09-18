package com.brasil.burger.brasilburger.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.brasil.burger.brasilburger.models.Boisson;
import com.brasil.burger.brasilburger.models.Taille;

public interface BoissonRepository extends JpaRepository<Boisson , Long>{
    Boisson findByTaille(Taille taille);
}
