package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Rooms;
import net.javaguides.springboot.model.Supervisors;
import net.javaguides.springboot.model.Typologies;
import net.javaguides.springboot.service.RoomsService;
import net.javaguides.springboot.service.SupervisorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/supervisors")
public class SupervisorsController {

    @Autowired
    private SupervisorsService supervisorsService;

    @GetMapping
    public ResponseEntity<List<Supervisors>> getAllSupervisors(){
        return ResponseEntity.ok(supervisorsService.getAllSupervisors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Supervisors>> supervisorById(@PathVariable Long id) {
        return ResponseEntity.ok(supervisorsService.getSupervisorById(id));
    }
}
