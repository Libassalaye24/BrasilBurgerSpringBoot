/* package com.brasil.burger.brasilburger.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.brasil.burger.brasilburger.models.Admin;
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
        User user = new Admin();
        user.setEmail("admin@mail.com");
        user.setNom("admin");
        user.setPrenom("admin");
        user.setPassword(encoder.encode("passer"));
        Role role = userService.findRoleByLibelle("ADMIN");
        user.setRole(role);
        userService.saveUser(user);
    }
}

 */