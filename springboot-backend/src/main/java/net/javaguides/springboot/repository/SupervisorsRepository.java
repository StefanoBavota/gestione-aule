package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Supervisors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisorsRepository extends JpaRepository<Supervisors, Long> {
}