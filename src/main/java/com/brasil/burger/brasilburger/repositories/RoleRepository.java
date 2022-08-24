package com.brasil.burger.brasilburger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasil.burger.brasilburger.models.Role;

public interface RoleRepository extends JpaRepository<Role , Long>{
    Role findByLibelle(String libelle);
}
