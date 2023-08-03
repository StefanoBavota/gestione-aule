package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.response.LocationsResponse;
import net.javaguides.springboot.model.Locations;
import net.javaguides.springboot.model.Typologies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LocationsService {

    public List<LocationsResponse> getAllLocations();

    Optional<LocationsResponse> getLocationById(Long idLocation);
}