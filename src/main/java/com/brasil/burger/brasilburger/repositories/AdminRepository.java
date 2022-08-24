package com.brasil.burger.brasilburger.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.brasil.burger.brasilburger.models.Admin;
public interface AdminRepository extends JpaRepository<Admin , Long> {
    public Admin findByEmail(String email);
    
}
