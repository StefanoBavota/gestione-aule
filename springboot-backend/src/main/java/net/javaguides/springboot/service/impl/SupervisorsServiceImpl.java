package net.javaguides.springboot.service.impl;

import jakarta.transaction.Transactional;
import net.javaguides.springboot.model.Supervisors;
import net.javaguides.springboot.model.Typologies;
import net.javaguides.springboot.repository.RoomsRepository;
import net.javaguides.springboot.repository.SupervisorsRepository;
import net.javaguides.springboot.service.SupervisorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SupervisorsServiceImpl implements SupervisorsService {

    @Autowired
    private SupervisorsRepository supervisorsRepository;

    @Override
    public List<Supervisors> getAllSupervisors() {
        return (List<Supervisors>) supervisorsRepository.findAll();
    }


    @Override
    public Optional<Supervisors> getSupervisorById(Long id) {
        return supervisorsRepository.findById(id);
    }
}
