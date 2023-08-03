package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Courses;
import net.javaguides.springboot.model.Typologies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CoursesService {

    public List<Courses> getAllCourses();

    Optional<Courses> getCourseById(Long idCourse);
}