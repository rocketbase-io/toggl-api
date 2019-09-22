package io.rocketbase.toggl.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {

    private Long id;

    private String name;

    @JsonProperty("wid")
    private Long workspaceId;

    private String notes;

    private Date at;
}
