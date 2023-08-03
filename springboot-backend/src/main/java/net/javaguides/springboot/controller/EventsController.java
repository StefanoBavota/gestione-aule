package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.request.EventsRequest;
import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.dto.response.RoomsResponse;
import net.javaguides.springboot.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @GetMapping
    public ResponseEntity<List<EventsResponse>> getAllEvents(@RequestParam(required = false) Long roomId){
        List<EventsResponse> eventsResponseList;

        if (roomId != null) {
            eventsResponseList = eventsService.getEventsByroomId(roomId);
        } else {
            eventsResponseList = eventsService.getAllEvents();
        }

        return ResponseEntity.ok(eventsResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EventsResponse>> groupById(@PathVariable Long id) {
        return ResponseEntity.ok(eventsService.getEventById(id));
    }

    @PostMapping
    public ResponseEntity<Long> createEvent(@RequestBody EventsRequest eventsRequest) {
        Long createdEvent = eventsService.saveOrUpdate(eventsRequest);
        return ResponseEntity.ok(createdEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateEvent(@PathVariable Long id, @RequestBody EventsRequest eventsRequest) {
        eventsRequest.setId(id);
        Long updatedEvent = eventsService.saveOrUpdate(eventsRequest);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventById(@PathVariable Long id) {
        eventsService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/rooms-current")
    public ResponseEntity<List<EventsResponse>> getAllEventsByClassId(@RequestParam Long classId, String selectedDay){
        return ResponseEntity.ok(eventsService.getAllEventsByClassId(classId, selectedDay));
    }

    @GetMapping("/course-current")
    public ResponseEntity<List<EventsResponse>> getAllEventsByCourseId(@RequestParam Long courseId, String selectedDay){
        return ResponseEntity.ok(eventsService.getAllEventsByCourseId(courseId, selectedDay));
    }

    @GetMapping("/next-events")
    public ResponseEntity<List<EventsResponse>> getNextEventsByGroupId(@RequestParam Long groupId){
        return ResponseEntity.ok(eventsService.getNextEventsByGroupId(groupId));
    }
}