package net.javaguides.springboot.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.javaguides.springboot.model.Events;
import net.javaguides.springboot.model.Rooms;
import net.javaguides.springboot.model.Supervisors;
import net.javaguides.springboot.model.Typologies;

import java.util.List;

@Data
@ToString
public class EventsRequest {

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

    @JsonProperty
    private Long room_id;

    @JsonProperty
    private Long supervisor_id;

    @JsonProperty
    private Long typology_id;

    @JsonProperty
    private List<Long> course_id;

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

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public Long getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(Long supervisor_id) {
        this.supervisor_id = supervisor_id;
    }

    public Long getTypology_id() {
        return typology_id;
    }

    public void setTypology_id(Long typology_id) {
        this.typology_id = typology_id;
    }

    public List<Long> getCourse_id() {
        return course_id;
    }

    public void setCourse_id(List<Long> course_id) {
        this.course_id = course_id;
    }

    public EventsRequest() {
    }

    public EventsRequest(Long id, String date, String startTime, String endTime, String name, String description, Long room_id, Long supervisor_id, Long typology_id, List<Long> course_id) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.description = description;
        this.room_id = room_id;
        this.supervisor_id = supervisor_id;
        this.typology_id = typology_id;
        this.course_id = course_id;
    }
}
