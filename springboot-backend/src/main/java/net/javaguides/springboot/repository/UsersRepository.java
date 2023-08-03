package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findUserByEmail(String email);
}