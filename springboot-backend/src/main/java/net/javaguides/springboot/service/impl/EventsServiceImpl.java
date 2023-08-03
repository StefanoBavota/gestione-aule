package net.javaguides.springboot.service.impl;

import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.javaguides.springboot.dto.request.EventsRequest;
import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.dto.response.RoomsResponse;
import net.javaguides.springboot.mapper.EventsMapper;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.repository.*;
import net.javaguides.springboot.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private TypologiesRepository typologiesRepository;

    @Autowired
    private SupervisorsRepository supervisorsRepository;

    @Autowired
    private RoomsRepository roomsRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private CourseEventRepository courseEventRepository;

    //------------- GET ALL -------------
    @Override
    public List<EventsResponse> getAllEvents() {
        Iterable<Events> eventsIterable = eventsRepository.findAll();
        return EventsMapper.entitiesToDTO(eventsIterable);
    }

    @Override
    public List<EventsResponse> getEventsByroomId(Long roomId) {
        Iterable<Events> eventsIterable = eventsRepository.findAllByRoomsId(roomId);
        return EventsMapper.entitiesToDTO(eventsIterable);
    }

    //------------- GET BY ID -------------
    @Override
    public Optional<EventsResponse> getEventById(Long id) {
        Optional<Events> event = eventsRepository.findById(id);

        return event.map(EventsMapper::mapEventToResponse);
    }

    //------------- WEEKLY EVENTS BY CLASS ID -------------
    @Override
    public List<EventsResponse> getAllEventsByClassId(Long classId, String selectedDay) {
        try {
            LocalDate selectedDate = LocalDate.parse(selectedDay);

            LocalDate startOfWeek = selectedDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            LocalDate endOfWeek = startOfWeek.plusDays(6);

            Iterable<Events> eventsIterable = eventsRepository.findAll();
            return EventsMapper.entitiesToDTOFilteredByRoomAndDate(eventsIterable, classId, startOfWeek, endOfWeek);
        } catch (DateTimeParseException e) {
            return new ArrayList<>();
        }
    }

    //------------- WEEKLY EVENTS BY COURSE ID -------------
    @Override
    public List<EventsResponse> getAllEventsByCourseId(Long courseId, String selectedDay) {
        try {
            LocalDate selectedDate = LocalDate.parse(selectedDay);

            LocalDate startOfWeek = selectedDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            LocalDate endOfWeek = startOfWeek.plusDays(6);

            Iterable<Events> eventsIterable = eventsRepository.findAll();
            return EventsMapper.entitiesToDTOFilteredByCourseAndDate(eventsIterable, courseId, startOfWeek, endOfWeek);
        } catch (DateTimeParseException e) {
            return new ArrayList<>();
        }
    }

    //------------- EVENTS NEXT THREE HOURS -------------
    @Override
    public List<EventsResponse> getNextEventsByGroupId(Long groupId) {
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime threeHoursLaterDateTime = nowDateTime.plusHours(3);

        List<EventsResponse> allEvents = getAllEvents();

        return EventsMapper.filterEventsByDateBetween(allEvents, nowDateTime, threeHoursLaterDateTime);
    }

    //------------- POST AND PUT -------------
    @Override
    public Long saveOrUpdate(EventsRequest eventsRequest) {
        Optional<Rooms> room = roomsRepository.findById(eventsRequest.getRoom_id());
        Optional<Supervisors> supervisor = supervisorsRepository.findById(eventsRequest.getSupervisor_id());
        Optional<Typologies> typology = typologiesRepository.findById(eventsRequest.getTypology_id());

        Events event = DTOUpdateEntity(eventsRequest, room, supervisor, typology);

        List<Long> courseIds = eventsRequest.getCourse_id();
        for (Long courseId : courseIds) {
            Courses course = coursesRepository.findById(courseId).orElse(null);
            if (course != null) {
                CourseEvent courseEvent = new CourseEvent();
                courseEvent.setCourses(course);
                courseEvent.setEvents(event);
                courseEventRepository.save(courseEvent);
            }
        }

        return event.getId();
    }

    private Events DTOUpdateEntity(EventsRequest eventsRequest, Optional<Rooms> room, Optional<Supervisors> supervisor, Optional<Typologies> typology) {
        Events event;
        if (eventsRequest.getId() != null) {
            Optional<Events> existingEvent = eventsRepository.findById(eventsRequest.getId());
            event = existingEvent.orElse(new Events());
        } else {
            event = new Events();
        }

        event.setDate(Date.valueOf(eventsRequest.getDate()).toLocalDate());
        event.setStartTime(LocalTime.parse(eventsRequest.getStartTime()));
        event.setEndTime(LocalTime.parse(eventsRequest.getEndTime()));
        event.setName(eventsRequest.getName());
        event.setDescription(eventsRequest.getDescription());

        event.setRooms(room.orElse(null));
        event.setSupervisors(supervisor.orElse(null));
        event.setTypologies(typology.orElse(null));

        return eventsRepository.save(event);
    }

    //------------- DELETE -------------
    @Override
    public void deleteEvent(Long id) {
        eventsRepository.deleteById(id);
    }
}
