package net.javaguides.springboot.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import net.javaguides.springboot.model.Groups;

@Data
public class GroupsResponse {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private String link;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public GroupsResponse() {
    }

    public GroupsResponse(Long id, String name, String description, String link) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.link = link;
    }
}
