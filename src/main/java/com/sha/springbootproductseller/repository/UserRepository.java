package com.sha.springbootproductseller.repository;

import com.sha.springbootproductseller.model.Role;
import com.sha.springbootproductseller.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//      User findByUsername(String username);



    Optional<User> findByUsername(String username);


//
//    @Modifying
//    @Query("update User set role = :role where username = :username")
//    void updateUserRole(@Param("username") String username, @Param("role") Role role);

}
