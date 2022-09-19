package com.brasil.burger.brasilburger.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.brasil.burger.brasilburger.models.Admin;
import com.brasil.burger.brasilburger.models.Client;
import com.brasil.burger.brasilburger.models.Role;
import com.brasil.burger.brasilburger.models.User;
import com.brasil.burger.brasilburger.services.UserService;



@Component
public class UserFixture {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void loadDefaultAdmin() {
        User user = new Client();
        user.setEmail("client1@mail.com");
        user.setNom("client1");
        user.setPrenom("client1");
        user.setPassword(encoder.encode("passer"));
        Role role = userService.findRoleByLibelle("CLIENT");
        user.setRole(role);
        userService.saveUser(user);
    }
}

