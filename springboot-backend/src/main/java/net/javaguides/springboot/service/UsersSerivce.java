package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Users;
import org.springframework.stereotype.Service;

@Service
public interface UsersSerivce {

    String login(String email, String password);
}
