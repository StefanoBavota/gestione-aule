package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Typologies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypologiesRepository extends JpaRepository<Typologies, Long> {
}