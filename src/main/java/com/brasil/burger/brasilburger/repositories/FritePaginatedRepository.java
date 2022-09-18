package com.brasil.burger.brasilburger.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.brasil.burger.brasilburger.models.Frite;

public interface FritePaginatedRepository extends PagingAndSortingRepository<Frite , Long>{
    Page<Frite> findByEtat(Boolean etat , Pageable pageable);
}
