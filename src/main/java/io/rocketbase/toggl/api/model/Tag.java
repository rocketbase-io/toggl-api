package io.rocketbase.toggl.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tag {

    private Long id;

    private String name;

    @JsonProperty("wid")
    private Long workspaceId;
}
