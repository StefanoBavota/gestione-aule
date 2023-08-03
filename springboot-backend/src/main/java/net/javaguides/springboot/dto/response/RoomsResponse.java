package net.javaguides.springboot.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.javaguides.springboot.model.Events;

import java.util.List;

public class RoomsResponse {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private int capacity;

    @JsonProperty
    private String description;

    @JsonProperty
    private int electricalOutlets;

    @JsonProperty
    private int ethernetPorts;

    @JsonProperty
    private String link;

    @JsonProperty("location_id")
    private Long locationId;

    @JsonProperty("supervisor_id")
    private Long supervisorId;

    @JsonProperty("group_id")
    private Long groupId;

    @JsonProperty
    private List<EventsResponse> events;

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

    public int getElectricalOutlets() {
        return electricalOutlets;
    }

    public void setElectricalOutlets(int electricalOutlets) {
        this.electricalOutlets = electricalOutlets;
    }

    public int getEthernetPorts() {
        return ethernetPorts;
    }

    public void setEthernetPorts(int ethernetPorts) {
        this.ethernetPorts = ethernetPorts;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<EventsResponse> getEvents() {
        return events;
    }

    public void setEvents(List<EventsResponse> events) {
        this.events = events;
    }

    public RoomsResponse() {
    }

    public RoomsResponse(Long id, String name, int capacity, String description, int electricalOutlets, int ethernetPorts, String link, Long locationId, Long supervisorId, Long groupId, List<EventsResponse> events) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.description = description;
        this.electricalOutlets = electricalOutlets;
        this.ethernetPorts = ethernetPorts;
        this.link = link;
        this.locationId = locationId;
        this.supervisorId = supervisorId;
        this.groupId = groupId;
        this.events = events;
    }
}
