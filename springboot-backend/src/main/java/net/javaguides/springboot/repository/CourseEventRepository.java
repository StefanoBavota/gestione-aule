package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.CourseEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEventRepository extends JpaRepository<CourseEvent, Long> {
}