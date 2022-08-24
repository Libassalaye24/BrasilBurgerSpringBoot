package com.brasil.burger.brasilburger.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brasil.burger.brasilburger.models.Admin;
import com.brasil.burger.brasilburger.models.Role;
import com.brasil.burger.brasilburger.models.User;
import com.brasil.burger.brasilburger.repositories.AdminRepository;
import com.brasil.burger.brasilburger.repositories.RoleRepository;
import com.brasil.burger.brasilburger.repositories.UserRepository;

import lombok.extern.java.Log;

@Service
@Log
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private RoleRepository roleRepository;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Admin findAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    public Role findRoleByLibelle(String libelle) {
        return roleRepository.findByLibelle(libelle);
    }

    public User saveUser(User user) {
        try {
            userRepository.save(user);
            return user;
        } catch(Exception e) {
            throw e;
        }
    }

}
