package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.response.RoomsResponse;
import net.javaguides.springboot.model.Groups;
import net.javaguides.springboot.model.Locations;
import net.javaguides.springboot.model.Rooms;
import net.javaguides.springboot.model.Supervisors;

import java.util.ArrayList;
import java.util.List;

public class RoomsMapper {

    // ------------- TO DTO -------------
    public static List<RoomsResponse> entitiesToDTO(Iterable<Rooms> roomsIterable) {
        List<RoomsResponse> roomsResponseList = new ArrayList<>();
        for (Rooms rooms : roomsIterable) {
            RoomsResponse response = mapRoomToResponse(rooms);

            roomsResponseList.add(response);
        }
        return roomsResponseList;
    }

    public static RoomsResponse mapRoomToResponse(Rooms rooms) {
        RoomsResponse response = new RoomsResponse();
        response.setId(rooms.getId());
        response.setName(rooms.getName());
        response.setCapacity(rooms.getCapacity());
        response.setDescription(rooms.getDescription());
        response.setElectricalOutlets(rooms.getElectrical_outlets());
        response.setEthernetPorts(rooms.getEthernet_ports());
        response.setLink(rooms.getLink());

        response.setLocationId(getIdFromLocations(rooms.getLocations()));
        response.setSupervisorId(getIdFromSupervisors(rooms.getSupervisors()));
        response.setGroupId(getIdFromGroups(rooms.getGroups()));

        return response;
    }

    public static Long getIdFromLocations(Locations locations) {
        return locations != null ? locations.getId() : null;
    }

    public static Long getIdFromSupervisors(Supervisors supervisors) {
        return supervisors != null ? supervisors.getId() : null;
    }

    public static Long getIdFromGroups(Groups groups) {
        return groups != null ? groups.getId() : null;
    }
    // ------------- END TO DTO -------------
}
