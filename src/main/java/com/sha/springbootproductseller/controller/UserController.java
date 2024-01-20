package com.sha.springbootproductseller.controller;

import com.sha.springbootproductseller.model.Product;
import com.sha.springbootproductseller.model.Role;
import com.sha.springbootproductseller.model.User;
import com.sha.springbootproductseller.service.UserService;
import com.sha.springbootproductseller.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user/")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PutMapping("change/{roleStr}/{userName}")
    public ResponseEntity<?> changeRole(@PathVariable String roleStr, @PathVariable String userName) {
        Role role = Role.USER;
        try {
            role = Role.valueOf(roleStr);
            // Now, 'role' contains the corresponding enum value
        } catch (IllegalArgumentException e) {
            ResponseEntity.internalServerError();
            // Handle the case where 'roleString' doesn't match any enum constant
        }
//        userService.changeRole(role, userName);
        return ResponseEntity.ok(true);
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }


//    @GetMapping("login")
}
