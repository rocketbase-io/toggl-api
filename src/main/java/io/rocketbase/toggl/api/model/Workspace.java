package io.rocketbase.toggl.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Workspace {

    private Long id;
    private String name;
    private boolean premium;
    private boolean admin;

    @JsonProperty("default_hourly_rate")
    private Float defaultHourlyRate;

    @JsonProperty("default_currency")
    private String defaultCurrency;

    @JsonProperty("only_admins_may_create_projects")
    private boolean onlyAdminsMayCreateProjects;

    @JsonProperty("only_admins_see_billable_rates")
    private boolean onlyAdminsSeeBillableRates;

    private RoundingType rounding;

    @JsonProperty("rounding_minutes")
    private Integer roundingMinutes;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private Instant at;

    @JsonProperty("logo_url")
    private String logoUrl;
}
