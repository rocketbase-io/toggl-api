package io.rocketbase.toggl.api;

import lombok.AccessLevel;
import lombok.Getter;

@Getter(AccessLevel.PACKAGE)
public class TogglApiBuilder {

    public static final String TOGGLE_API = "toggl.com/api/v8";

    private String host = TOGGLE_API;
    private String apiToken = null;
    private String userAgent = null;

    public TogglApiBuilder apiToken(String apiToken) {
        this.apiToken = apiToken;
        return this;
    }

    public TogglApiBuilder userAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public TogglApi build() {
        RequestContext context = new RequestContext(this);
        return new TogglApi(context);
    }

}
