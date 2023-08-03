package net.javaguides.springboot.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LocationsResponse {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String place;

    @JsonProperty
    private String building;

    @JsonProperty
    private String floor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public LocationsResponse() {
    }

    public LocationsResponse(Long id, String place, String building, String floor) {
        this.id = id;
        this.place = place;
        this.building = building;
        this.floor = floor;
    }
}
