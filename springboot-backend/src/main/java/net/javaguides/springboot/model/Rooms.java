package net.javaguides.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "capacity")
    private int capacity;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "electrical_outlets")
    private int electrical_outlets;

    @NotNull
    @Column(name = "ethernet_ports")
    private int ethernet_ports;

    @NotNull
    @Column(name = "link")
    private String link;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    @JsonBackReference
    private Supervisors supervisors;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "group_id")
    @JsonBackReference
    private Groups groups;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonBackReference
    private Locations locations;

    @OneToMany(mappedBy = "rooms")
    @JsonBackReference
    private List<Events> events;

    @OneToMany(mappedBy = "rooms")
    @JsonBackReference
    private List<AssetsRoom> assetRooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getElectrical_outlets() {
        return electrical_outlets;
    }

    public void setElectrical_outlets(int electrical_outlets) {
        this.electrical_outlets = electrical_outlets;
    }

    public int getEthernet_ports() {
        return ethernet_ports;
    }

    public void setEthernet_ports(int ethernet_ports) {
        this.ethernet_ports = ethernet_ports;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Supervisors getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(Supervisors supervisors) {
        this.supervisors = supervisors;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

    public List<AssetsRoom> getAssetRooms() {
        return assetRooms;
    }

    public void setAssetRooms(List<AssetsRoom> assetRooms) {
        this.assetRooms = assetRooms;
    }

    public Rooms() {
    }
}
