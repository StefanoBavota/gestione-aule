package net.javaguides.springboot.dto.response;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.javaguides.springboot.model.Courses;
import net.javaguides.springboot.model.Rooms;
import net.javaguides.springboot.model.Supervisors;
import net.javaguides.springboot.model.Typologies;

import java.util.List;

public class EventsResponse {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String date;

    @JsonProperty
    private String startTime;

    @JsonProperty
    private String endTime;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty("typology_id")
    private Long typologyId;

    @JsonProperty("supervisor_id")
    private Long supervisorId;

    @JsonProperty("room_id")
    private Long roomId;

    @JsonProperty("room")
    @JsonManagedReference
    private Rooms room;

    @JsonProperty("supervisor")
    @JsonManagedReference
    private Supervisors supervisor;

    @JsonProperty("typology")
    @JsonManagedReference
    private Typologies typology;

    @JsonProperty("courses")
    @JsonManagedReference
    private List<Courses> course;

    @JsonProperty("course_id")
    private List<Long> courseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTypologyId() {
        return typologyId;
    }

    public void setTypologyId(Long typologyId) {
        this.typologyId = typologyId;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public Supervisors getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisors supervisor) {
        this.supervisor = supervisor;
    }

    public Typologies getTypology() {
        return typology;
    }

    public void setTypology(Typologies typology) {
        this.typology = typology;
    }

    public List<Courses> getCourse() {
        return course;
    }

    public void setCourse(List<Courses> course) {
        this.course = course;
    }

    public List<Long> getCourseId() {
        return courseId;
    }

    public void setCourseId(List<Long> courseId) {
        this.courseId = courseId;
    }

    public EventsResponse() {
    }

    public EventsResponse(Long id, String date, String startTime, String endTime, String name, String description, Long typologyId, Long supervisorId, Long roomId, Rooms room, Supervisors supervisor, Typologies typology, List<Courses> course, List<Long> courseId) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.description = description;
        this.typologyId = typologyId;
        this.supervisorId = supervisorId;
        this.roomId = roomId;
        this.room = room;
        this.supervisor = supervisor;
        this.typology = typology;
        this.course = course;
        this.courseId = courseId;
    }
}
