package io.rocketbase.toggl.api;

import io.rocketbase.toggl.api.resource.ClientResource;
import io.rocketbase.toggl.api.resource.WorkspacesResource;

public class TogglApi {

    private final RequestContext context;

    TogglApi(RequestContext context) {
        this.context = context;
    }

    public WorkspacesResource workspaces() {
        return new WorkspacesResource(context);
    }

    public ClientResource client() {
        return new ClientResource(context);
    }

}
