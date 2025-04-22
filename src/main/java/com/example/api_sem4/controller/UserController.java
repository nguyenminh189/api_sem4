package com.example.api_sem4.controller;

import com.example.api_sem4.dto.UserDTO;
import com.example.api_sem4.entity.User;
import com.example.api_sem4.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO){
        User savedUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(savedUser);
    }
}
