package net.javaguides.springboot.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RoomsRequest {

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

    @JsonProperty
    private Long location_id;

    @JsonProperty
    private Long supervisor_id;

    @JsonProperty
    private Long group_id;

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

    public Long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
    }

    public Long getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(Long supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }

    public RoomsRequest() {
    }

    public RoomsRequest(Long id, String name, int capacity, String description, int electricalOutlets, int ethernetPorts, String link, Long location_id, Long supervisor_id, Long group_id) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.description = description;
        this.electricalOutlets = electricalOutlets;
        this.ethernetPorts = ethernetPorts;
        this.link = link;
        this.location_id = location_id;
        this.supervisor_id = supervisor_id;
        this.group_id = group_id;
    }
}
