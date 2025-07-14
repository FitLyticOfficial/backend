package com.fitlytic.backend.controller;

import com.fitlytic.backend.dto.UserDTO;
import com.fitlytic.backend.model.User;
import com.fitlytic.backend.security.JWTUtil;
import com.fitlytic.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private final JWTUtil jwtUtil;

    public UserController(UserService userService, JWTUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO dto) {
        User user = userService.register(dto);
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO dto) {
        return userService.authenticate(dto.getUsername(), dto.getPassword())
                .map(user -> ResponseEntity.ok(jwtUtil.generateToken(user.getUsername())))
                .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }
}
