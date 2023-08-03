package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.response.LocationsResponse;
import net.javaguides.springboot.model.Locations;
import net.javaguides.springboot.model.Typologies;
import net.javaguides.springboot.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/locations")
public class LocationsController {

    @Autowired
    private LocationsService locationsService;

    @GetMapping
    public ResponseEntity<List<LocationsResponse>> getAllTypologies(){
        return ResponseEntity.ok(locationsService.getAllLocations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LocationsResponse>> getLocationById(@PathVariable Long id) {
        return ResponseEntity.ok(locationsService.getLocationById(id));
    }
}
