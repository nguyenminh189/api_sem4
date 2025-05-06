package com.example.api_sem4.controller;

import com.example.api_sem4.dto.LoginResponse;
import com.example.api_sem4.dto.LoginUser;
import com.example.api_sem4.dto.RegisterUser;
import com.example.api_sem4.entity.User;
import com.example.api_sem4.service.JwtService;
import com.example.api_sem4.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final JwtService jwtService;

    public UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;

        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUser req){
        User user = userService.signUp(req);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUser req){
        User user = userService.authenticate(req);
        String jwtToken = jwtService.generateToken(user);
        LoginResponse rs = new LoginResponse();
        rs.setToken(jwtToken);
        return ResponseEntity.ok(rs);
    }
}
