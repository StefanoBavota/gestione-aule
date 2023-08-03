package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.response.EventsResponse;
import net.javaguides.springboot.model.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventsMapper {

    //------------- WEEKLY EVENTS BY CLASS ID -------------
    public static List<EventsResponse> entitiesToDTOFilteredByRoomAndDate(Iterable<Events> eventsIterable, Long classId, LocalDate startOfWeek, LocalDate endOfWeek) {
        List<EventsResponse> eventsResponseList = new ArrayList<>();
        for (Events events : eventsIterable) {
            if (events.getRooms() != null && events.getRooms().getId() == classId && isEventWithinWeek(events.getDate(), startOfWeek, endOfWeek)) {
                EventsResponse response = mapEventToResponse(events);
                response.setCourse(getCoursesForEvent(events));
                eventsResponseList.add(response);
            }
        }
        return eventsResponseList;
    }

    public static boolean isEventWithinWeek(LocalDate eventDate, LocalDate startOfWeek, LocalDate endOfWeek) {
        return !eventDate.isBefore(startOfWeek) && !eventDate.isAfter(endOfWeek);
    }
    //------------- END WEEKLY EVENTS BY CLASS ID -------------

    //------------- WEEKLY EVENTS BY COURSE ID -------------
    public static List<EventsResponse> entitiesToDTOFilteredByCourseAndDate(Iterable<Events> eventsIterable, Long courseId, LocalDate startOfWeek, LocalDate endOfWeek) {
        List<EventsResponse> eventsResponseList = new ArrayList<>();
        for (Events events : eventsIterable) {
            for (CourseEvent courseEvent : events.getCourseEvent()) {
                Courses course = courseEvent.getCourses();
                if (course != null && course.getId().equals(courseId) && isEventCourseWithinWeek(events.getDate(), startOfWeek, endOfWeek)) {
                    EventsResponse response = mapEventToResponse(events);
                    response.setCourse(getCoursesForEvent(events));
                    eventsResponseList.add(response);
                    break;
                }
            }
        }
        return eventsResponseList;
    }

    public static boolean isEventCourseWithinWeek(LocalDate eventDate, LocalDate startOfWeek, LocalDate endOfWeek) {
        return !eventDate.isBefore(startOfWeek) && !eventDate.isAfter(endOfWeek);
    }
    //------------- END WEEKLY EVENTS BY COURSE ID -------------

    // ------------- EVENTS NEXT THREE HOURS  -------------
    public static List<EventsResponse> filterEventsByDateBetween(List<EventsResponse> eventsList, LocalDateTime startTime, LocalDateTime endTime) {
        List<EventsResponse> filteredEvents = new ArrayList<>();
        for (EventsResponse event : eventsList) {
            LocalDate eventDate = LocalDate.parse(event.getDate());
            LocalTime eventStartTime = LocalTime.parse(event.getStartTime());
            LocalDateTime eventStartDateTime = eventDate.atTime(eventStartTime);

            if (eventStartDateTime.isAfter(startTime) && eventStartDateTime.isBefore(endTime)) {
                filteredEvents.add(event);
            }
        }
        return filteredEvents;
    }
    // ------------- END EVENTS NEXT THREE HOURS  -------------

    // ------------- TO DTO -------------
    public static List<EventsResponse> entitiesToDTO(Iterable<Events> eventsIterable) {
        List<EventsResponse> eventsResponseList = new ArrayList<>();
        for (Events events : eventsIterable) {
            EventsResponse response = mapEventToResponse(events);
            List<Courses> coursesForEvent = getCoursesForEvent(events);
            response.setCourse(coursesForEvent);

            eventsResponseList.add(response);
        }
        return eventsResponseList;
    }

    public static EventsResponse mapEventToResponse(Events events) {
        EventsResponse response = new EventsResponse();
        response.setId(events.getId());
        response.setDate(events.getDate().toString());
        response.setName(events.getName());
        response.setDescription(events.getDescription());

        response.setStartTime(events.getStartTime() != null ? events.getStartTime().toString() : null);
        response.setEndTime(events.getEndTime() != null ? events.getEndTime().toString() : null);
        response.setTypologyId(getIdFromTypologies(events.getTypologies()));
        response.setSupervisorId(getIdFromSupervisors(events.getSupervisors()));
        response.setRoomId(getIdFromRooms(events.getRooms()));

        response.setTypology(events.getTypologies());
        response.setSupervisor(events.getSupervisors());
        response.setRoom(events.getRooms());

        List<Courses> coursesForEvent = getCoursesForEvent(events);
        response.setCourse(coursesForEvent);

        response.setCourseId(coursesForEvent.stream().map(Courses::getId).collect(Collectors.toList()));

        return response;
    }

    public static List<Courses> getCoursesForEvent(Events events) {
        List<Courses> coursesForEvent = new ArrayList<>();
        List<CourseEvent> courseEvents = events.getCourseEvent();
        for (CourseEvent courseEvent : courseEvents) {
            Courses course = courseEvent.getCourses();
            if (course != null) {
                coursesForEvent.add(course);
            }
        }

        return coursesForEvent;
    }

    public static Long getIdFromTypologies(Typologies typologies) {
        return typologies != null ? typologies.getId() : null;
    }

    public static Long getIdFromSupervisors(Supervisors supervisors) {
        return supervisors != null ? supervisors.getId() : null;
    }

    public static Long getIdFromRooms(Rooms rooms) {
        return rooms != null ? rooms.getId() : null;
    }
    // ------------- END TO DTO -------------
}
