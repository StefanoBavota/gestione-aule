package net.javaguides.springboot.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import net.javaguides.springboot.dto.request.EventsRequest;
import net.javaguides.springboot.dto.request.RoomsRequest;
import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.dto.response.RoomsResponse;
import net.javaguides.springboot.mapper.EventsMapper;
import net.javaguides.springboot.mapper.RoomsMapper;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.repository.*;
import net.javaguides.springboot.service.EventsService;
import net.javaguides.springboot.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoomServiceImpl implements RoomsService {

    @Autowired
    private RoomsRepository roomsRepository;

    @Autowired
    private LocationsRepository locationsRepository;

    @Autowired
    private SupervisorsRepository supervisorsRepository;

    @Autowired
    private GroupsRepository groupsRepository;

    @Autowired
    private EventsService eventsService;

    //------------- GET ALL -------------
    @Override
    public List<RoomsResponse> getAllRooms() {
        Iterable<Rooms> roomsIterable = roomsRepository.findAll();
        return RoomsMapper.entitiesToDTO(roomsIterable);
    }

    @Override
    public List<RoomsResponse> getRoomsByGroupId(Long groupId) {
        Iterable<Rooms> roomsIterable = roomsRepository.findAllByGroupsId(groupId);
        return RoomsMapper.entitiesToDTO(roomsIterable);
    }

    //------------- GET BY ID -------------
    @Override
    public Optional<RoomsResponse> getRoomById(Long id) {
        Optional<Rooms> room = roomsRepository.findById(id);

        return room.map(RoomsMapper::mapRoomToResponse);
    }

    //------------- GET ROOMS WITH EVENTS OF DAY -------------
    @Override
    public List<RoomsResponse> getRoomEventsByDateAndGroup(Long groupId, String selectedDay) {
        Iterable<Rooms> roomsIterable = roomsRepository.findAllByGroupsId(groupId);

        List<RoomsResponse> roomsWithEventsOnSelectedDay = new ArrayList<>();

        for (Rooms room : roomsIterable) {
            List<EventsResponse> allEventsForRoom = eventsService.getEventsByroomId(room.getId());

            List<EventsResponse> eventsOnSelectedDay = allEventsForRoom.stream()
                    .filter(event -> event.getDate().equals(selectedDay))
                    .toList();

            if (!eventsOnSelectedDay.isEmpty()) {
                List<EventsResponse> eventsResponseList = new ArrayList<>(eventsOnSelectedDay);

                RoomsResponse roomResponse = RoomsMapper.mapRoomToResponse(room);
                roomResponse.setEvents(eventsResponseList);

                roomsWithEventsOnSelectedDay.add(roomResponse);
            }
        }

        return roomsWithEventsOnSelectedDay;
    }

    //------------- POST AND PUT -------------
    @Override
    public Long saveOrUpdate(RoomsRequest roomsRequest) {
        Optional<Locations> location = locationsRepository.findById(roomsRequest.getLocation_id());
        Optional<Supervisors> supervisor = supervisorsRepository.findById(roomsRequest.getSupervisor_id());
        Optional<Groups> group = groupsRepository.findById(roomsRequest.getGroup_id());

        Rooms room = DTOUpdateEntity(roomsRequest, location, supervisor, group);

        return room.getId();
    }

    private Rooms DTOUpdateEntity(RoomsRequest roomsRequest, Optional<Locations> location, Optional<Supervisors> supervisor, Optional<Groups> group) {
        Rooms room;
        if (roomsRequest.getId() != null) {
            Optional<Rooms> existingEvent = roomsRepository.findById(roomsRequest.getId());
            room = existingEvent.orElse(new Rooms());
        } else {
            room = new Rooms();
        }

        room.setName(roomsRequest.getName());
        room.setCapacity(roomsRequest.getCapacity());
        room.setDescription(roomsRequest.getDescription());
        room.setElectrical_outlets(roomsRequest.getElectricalOutlets());
        room.setEthernet_ports(roomsRequest.getEthernetPorts());
        room.setLink(roomsRequest.getLink());

        room.setLocations(location.orElse(null));
        room.setSupervisors(supervisor.orElse(null));
        room.setGroups(group.orElse(null));

        return roomsRepository.save(room);
    }

    //------------- DELETE -------------
    @Override
    public void deleteRoom(Long id) {
        roomsRepository.deleteById(id);
    }
}