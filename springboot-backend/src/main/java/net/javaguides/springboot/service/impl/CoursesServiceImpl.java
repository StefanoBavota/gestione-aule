package net.javaguides.springboot.service.impl;

import jakarta.transaction.Transactional;
import net.javaguides.springboot.model.Courses;
import net.javaguides.springboot.repository.CoursesRepository;
import net.javaguides.springboot.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CoursesServiceImpl implements CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    @Override
    public List<Courses> getAllCourses() {
        return (List<Courses>) coursesRepository.findAll();
    }

    @Override
    public Optional<Courses> getCourseById(Long id) {
        return coursesRepository.findById(id);
    }
}
