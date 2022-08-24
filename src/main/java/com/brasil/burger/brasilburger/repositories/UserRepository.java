package com.brasil.burger.brasilburger.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasil.burger.brasilburger.models.User;

public interface UserRepository extends JpaRepository<User , Long>{
    public User findByEmail(String email);
}
