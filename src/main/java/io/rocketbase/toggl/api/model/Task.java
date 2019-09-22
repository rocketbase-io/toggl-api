package io.rocketbase.toggl.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {

    private Long id;

    private String name;

    @JsonProperty("wid")
    private Long workspaceId;

    @JsonProperty("uid")
    private Long assignedUserId;

    @JsonProperty("estimated_seconds")
    private Long estimatedSeconds;

    private boolean active;

    private Date at;

    @JsonProperty("tracked_seconds")
    private Long trackedSeconds;
}
