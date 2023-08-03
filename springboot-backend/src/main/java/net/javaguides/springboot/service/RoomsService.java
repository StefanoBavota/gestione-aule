package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.request.RoomsRequest;
import net.javaguides.springboot.dto.response.RoomsResponse;
import net.javaguides.springboot.model.Rooms;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RoomsService {

    public List<RoomsResponse> getAllRooms();

    List<RoomsResponse> getRoomsByGroupId(Long groupId);

    Long saveOrUpdate(RoomsRequest roomsRequest);

    Optional<RoomsResponse> getRoomById(Long idRoom);

    void deleteRoom(Long idRoom);

    List<RoomsResponse> getRoomEventsByDateAndGroup(Long groupId, String selectedDay);
}
