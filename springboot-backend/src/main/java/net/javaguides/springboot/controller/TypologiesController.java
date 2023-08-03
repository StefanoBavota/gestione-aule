package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.model.Supervisors;
import net.javaguides.springboot.model.Typologies;
import net.javaguides.springboot.service.SupervisorsService;
import net.javaguides.springboot.service.TypologiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/typologies")
public class TypologiesController {

    @Autowired
    private TypologiesService typologiesService;

    @GetMapping
    public ResponseEntity<List<Typologies>> getAllTypologies(){
        return ResponseEntity.ok(typologiesService.getAllTypologies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Typologies>> typologyById(@PathVariable Long id) {
        return ResponseEntity.ok(typologiesService.getTypologyById(id));
    }
}
