package com.brasil.burger.brasilburger.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brasil.burger.brasilburger.models.Boisson;

public interface BoissonPaginatedRepository extends PagingAndSortingRepository<Boisson , Long>{
    List<Boisson> findByEtat(Boolean etat,Pageable pageable);
    
}
