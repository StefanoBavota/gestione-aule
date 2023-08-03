package net.javaguides.springboot.service.impl;

import jakarta.transaction.Transactional;
import net.javaguides.springboot.dto.response.GroupsResponse;
import net.javaguides.springboot.dto.response.LocationsResponse;
import net.javaguides.springboot.model.Groups;
import net.javaguides.springboot.model.Locations;
import net.javaguides.springboot.repository.LocationsRepository;
import net.javaguides.springboot.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class LocationsServiceImpl implements LocationsService {

    @Autowired
    private LocationsRepository locationsRepository;

    //------------- GET ALL -------------
    @Override
    public List<LocationsResponse> getAllLocations() {
        List<Locations> locationsList = locationsRepository.findAll();

        return locationsList.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

    }

    //------------- GET BY ID -------------
    @Override
    public Optional<LocationsResponse> getLocationById(Long id) {
        Optional<Locations> location = locationsRepository.findById(id);

        return location.map(this::mapToDto);
    }

    private LocationsResponse mapToDto(Locations locations) {
        LocationsResponse response = new LocationsResponse();
        response.setId(locations.getId());
        response.setPlace(locations.getPlace());
        response.setBuilding(locations.getBuilding());
        response.setFloor(locations.getFloor());

        return response;
    }
}
