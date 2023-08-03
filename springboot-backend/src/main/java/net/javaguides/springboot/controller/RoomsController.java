package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.request.RoomsRequest;
import net.javaguides.springboot.dto.response.RoomsResponse;
import net.javaguides.springboot.model.Rooms;
import net.javaguides.springboot.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/rooms")
public class RoomsController {

    @Autowired
    private RoomsService roomsService;

    @GetMapping
    public ResponseEntity<List<RoomsResponse>> getAllRooms(@RequestParam(required = false) Long groupId) {
        List<RoomsResponse> roomsResponseList;

        if (groupId != null) {
            roomsResponseList = roomsService.getRoomsByGroupId(groupId);
        } else {
            roomsResponseList = roomsService.getAllRooms();
        }

        return ResponseEntity.ok(roomsResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<RoomsResponse>> roomById(@PathVariable Long id) {
        return ResponseEntity.ok(roomsService.getRoomById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createRoom(@RequestBody RoomsRequest roomsRequest) {
        Long createdRoom = roomsService.saveOrUpdate(roomsRequest);
        return ResponseEntity.ok(createdRoom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateRoom(@PathVariable Long id, @RequestBody RoomsRequest roomsRequest) {
        roomsRequest.setId(id);
        Long updatedRoom = roomsService.saveOrUpdate(roomsRequest);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomById(@PathVariable Long id) {
        roomsService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-room-events")
    public ResponseEntity<List<RoomsResponse>> getRoomEventsByDateAndGroup(@RequestParam Long groupId, String selectedDay) {
        return ResponseEntity.ok(roomsService.getRoomEventsByDateAndGroup(groupId, selectedDay));
    }
}
