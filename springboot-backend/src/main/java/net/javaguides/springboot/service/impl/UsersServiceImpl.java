package net.javaguides.springboot.service.impl;

import jakarta.transaction.Transactional;
import net.javaguides.springboot.AuthConfig.JwtUtil;
import net.javaguides.springboot.model.Users;
import net.javaguides.springboot.repository.UsersRepository;
import net.javaguides.springboot.service.UsersSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Transactional
public class UsersServiceImpl implements UsersSerivce {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String login(String email, String password) {
        Users user = usersRepository.findUserByEmail(email);
        if (user != null && (Objects.equals(password, user.getPassword()))) {
            return jwtUtil.generateToken(user);
        }
        throw new RuntimeException("Invalid email or password");
    }
}
