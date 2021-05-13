package io.rocketbase.toggl.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Client {

    private Long id;

    private String name;

    @JsonProperty("wid")
    private Long workspaceId;

    private String notes;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private Instant at;
}
