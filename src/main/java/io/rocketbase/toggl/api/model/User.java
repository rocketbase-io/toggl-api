package io.rocketbase.toggl.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private Long id;

    @JsonProperty("api_token")
    private String apiToken;

    @JsonProperty("default_wid")
    private Long defaultWorkspaceId;

    private String email;

    private String fullname;

    @JsonProperty("jquery_timeofday_format")
    private String jqueryTimeOfDayFormat;

    @JsonProperty("jquery_date_format")
    private String jqueryDateFormat;

    @JsonProperty("timeofday_format")
    private String timeOfDayFormat;

    @JsonProperty("date_format")
    private String dateFormat;

    /**
     * whether start and stop time are saved on time entry
     */
    @JsonProperty("store_start_and_stop_time")
    private boolean storeStartAndStopTime;

    /**
     * 0-6, Sunday=0
     */
    @JsonProperty("beginning_of_week")
    private Integer beginningOfWeek;

    @JsonProperty("language")
    private String language;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("sidebar_piechart")
    private boolean sidebarPiechart;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private Instant at;

    /**
     * Toggl can send newsletters over e-mail to the user
     */
    @JsonProperty("send_product_emails")
    private boolean sendProductEmails;

    /**
     * if user receives weekly report
     */
    @JsonProperty("send_weekly_report")
    private boolean sendWeeklyReport;

    /**
     * email user about long-running (more than 8 hours) tasks
     */
    @JsonProperty("send_timer_notifications")
    private boolean sendTimeNotifications;

    /**
     * google signin enabled
     */
    @JsonProperty("openid_enabled")
    private boolean openIdEnabled;

    /**
     * timezone user has set on the "My profile" page ( IANA TZ timezones )
     */
    private String timezone;
}
