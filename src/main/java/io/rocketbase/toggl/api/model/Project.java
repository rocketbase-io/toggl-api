package io.rocketbase.toggl.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    private Long id;

    private String name;

    @JsonProperty("wid")
    private Long workspaceId;

    @JsonProperty("cid")
    private Long clientId;

    private boolean active;

    @JsonProperty("is_private")
    private boolean privateAccess;

    private boolean billable;

    @JsonProperty("auto_estimates")
    private boolean autoEstimate;

    @JsonProperty("estimated_hours")
    private Integer estimatedHours;

    private Date at;

    private Long color;

    private Float rate;
}
