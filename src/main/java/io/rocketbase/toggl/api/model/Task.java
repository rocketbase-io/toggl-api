package io.rocketbase.toggl.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {

    private Long id;

    private String name;

    @JsonProperty("wid")
    private Long workspaceId;

    @JsonProperty("pid")
    private Long projectId;

    @JsonProperty("uid")
    private Long assignedUserId;

    @JsonProperty("estimated_seconds")
    private Long estimatedSeconds;

    private boolean active;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private Instant at;

    @JsonProperty("tracked_seconds")
    private Long trackedSeconds;
}
