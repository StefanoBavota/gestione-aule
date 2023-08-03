package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Users;
import net.javaguides.springboot.service.UsersSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class UsersController {

    @Autowired
    private UsersSerivce usersSerivce;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user) {
        String token = usersSerivce.login(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(token);
    }
}
