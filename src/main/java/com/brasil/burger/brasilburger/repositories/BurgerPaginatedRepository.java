package com.brasil.burger.brasilburger.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.brasil.burger.brasilburger.models.Burger;

@Repository
public interface BurgerPaginatedRepository extends PagingAndSortingRepository<Burger , Long>{
    List<Burger> findByEtat(Boolean etat);
}
