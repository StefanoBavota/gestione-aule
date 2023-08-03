package net.javaguides.springboot.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import net.javaguides.springboot.dto.request.EventsRequest;
import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.dto.response.GroupsResponse;
import net.javaguides.springboot.model.Events;
import org.springframework.stereotype.Service;

@Service
public interface EventsService {

    public List<EventsResponse> getAllEvents();

    List<EventsResponse> getEventsByroomId (Long roomId);

    Optional<EventsResponse> getEventById(Long idEvent);

    Long saveOrUpdate(EventsRequest eventsRequest);

    void deleteEvent(Long idEvent);

    public List<EventsResponse> getAllEventsByClassId(Long classId, String selectedDay);

    public List<EventsResponse> getAllEventsByCourseId(Long courseId, String selectedDay);

    public List<EventsResponse> getNextEventsByGroupId(Long groupId);
}