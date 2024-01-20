package com.sha.springbootproductseller.service;

import com.sha.springbootproductseller.model.Role;
import com.sha.springbootproductseller.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {
    User saveUser(User user);

//    User authenticate(User user);






//    Optional<User> findByUsername(String username);

//    void changeRole(Role newRole, String username);
}
