package net.javaguides.springboot.controller;

import net.javaguides.springboot.AuthConfig.JwtFilter;
import net.javaguides.springboot.model.Users;
import net.javaguides.springboot.service.UsersSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class UsersController {

    @Autowired
    private UsersSerivce usersSerivce;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Users user) {
        String token = usersSerivce.login(user.getEmail(), user.getPassword());

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
