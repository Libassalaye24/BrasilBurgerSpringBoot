package com.brasil.burger.brasilburger.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.brasil.burger.brasilburger.models.Menu;

public interface MenuPaginatedRepository extends PagingAndSortingRepository<Menu , Long>{
    List<Menu> findByEtat(Boolean etat);
}
