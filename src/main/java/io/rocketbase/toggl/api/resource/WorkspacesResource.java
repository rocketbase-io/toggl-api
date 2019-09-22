package io.rocketbase.toggl.api.resource;

import io.rocketbase.toggl.api.RequestContext;
import io.rocketbase.toggl.api.model.*;
import io.rocketbase.toggl.api.util.DataWrapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.List;

@RequiredArgsConstructor
public class WorkspacesResource {

    private final RequestContext requestContext;

    @SneakyThrows
    public List<Workspace> getWorkspaces() {
        return requestContext.execute(requestContext.getUriBuilder().path("/workspaces"),
                HttpMethod.GET, new ParameterizedTypeReference<List<Workspace>>() {
                });
    }

    @SneakyThrows
    public Workspace getWorkspace(long workspaceId) {
        DataWrapper<Workspace> wrapper = requestContext.execute(requestContext.getUriBuilder().path("/workspaces").path("/" + workspaceId),
                HttpMethod.GET, new ParameterizedTypeReference<DataWrapper<Workspace>>() {
                });
        return wrapper.getData();
    }

    @SneakyThrows
    public List<User> getWorkspaceUsers(long workspaceId) {
        return requestContext.execute(requestContext.getUriBuilder().path("/workspaces").path("/" + workspaceId).path("/users"),
                HttpMethod.GET, new ParameterizedTypeReference<List<User>>() {
                });
    }

    @SneakyThrows
    public List<Client> getWorkspaceClients(long workspaceId) {
        return requestContext.execute(requestContext.getUriBuilder().path("/workspaces").path("/" + workspaceId).path("/clients"),
                HttpMethod.GET, new ParameterizedTypeReference<List<Client>>() {
                });
    }

    @SneakyThrows
    public List<Project> getWorkspaceProjects(long workspaceId) {
        return requestContext.execute(requestContext.getUriBuilder().path("/workspaces").path("/" + workspaceId).path("/projects"),
                HttpMethod.GET, new ParameterizedTypeReference<List<Project>>() {
                });
    }

    @SneakyThrows
    public List<Task> getWorkspaceTasks(long workspaceId) {
        return requestContext.execute(requestContext.getUriBuilder().path("/workspaces").path("/" + workspaceId).path("/tasks"),
                HttpMethod.GET, new ParameterizedTypeReference<List<Task>>() {
                });
    }

    @SneakyThrows
    public List<Tag> getWorkspaceTags(long workspaceId) {
        return requestContext.execute(requestContext.getUriBuilder().path("/workspaces").path("/" + workspaceId).path("/tags"),
                HttpMethod.GET, new ParameterizedTypeReference<List<Tag>>() {
                });
    }

}
