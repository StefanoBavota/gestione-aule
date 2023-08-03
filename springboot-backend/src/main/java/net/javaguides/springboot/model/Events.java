package net.javaguides.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "date")
    private LocalDate date;

    @NotNull
    @Column(name = "start_time")
    private LocalTime startTime;

    @NotNull
    @Column(name = "end_time")
    private LocalTime endTime;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "typology_id")
    @JsonIgnoreProperties("events")
    private Typologies typologies;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    @JsonIgnoreProperties("events")
    private Supervisors supervisors;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonIgnoreProperties("events")
    private Rooms rooms;

    @OneToMany(mappedBy = "events")
    @JsonManagedReference
    private List<CourseEvent> courseEvent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime  startTime) {
        this.startTime = startTime;
    }

    public LocalTime  getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
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

    public Typologies getTypologies() {
        return typologies;
    }

    public void setTypologies(Typologies typologies) {
        this.typologies = typologies;
    }

    public Supervisors getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(Supervisors supervisors) {
        this.supervisors = supervisors;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public List<CourseEvent> getCourseEvent() {
        return courseEvent;
    }

    public void setCourseEvent(List<CourseEvent> courseEvent) {
        this.courseEvent = courseEvent;
    }

    public Events() {
    }

    public Events(LocalDate date, LocalTime startTime, LocalTime endTime, String name, String description, Typologies typologies, Supervisors supervisors, Rooms rooms, List<CourseEvent> courseEvent) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.description = description;
        this.typologies = typologies;
        this.supervisors = supervisors;
        this.rooms = rooms;
        this.courseEvent = courseEvent;
    }
}
