package io.rocketbase.toggl.api;

import io.rocketbase.toggl.api.model.*;
import lombok.SneakyThrows;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by marten on 19.01.17.
 */
public class TogglApiTest {

    protected TogglApi getTogglApi() {
        String apiToken = "api_token";
        Long workSpaceId = 0L;
        try {
            apiToken = System.getenv("API_TOKEN");
            workSpaceId = Long.parseLong(System.getenv("WORKSPACE_ID"));
        } catch (Exception e) {
            System.err.println("System Env not set use defaults");
        }

        return new TogglApiBuilder()
                .apiToken(apiToken)
                .userAgent("java-test")
                .build();
    }

    @SneakyThrows
    @Test
    public void workspacesList() {
        TogglApi togglApi = getTogglApi();

        List<Workspace> resultList = togglApi.workspaces().getWorkspaces();

        assertThat(resultList, notNullValue());
    }

    @SneakyThrows
    @Test
    public void workspacesGetById() {
        TogglApi togglApi = getTogglApi();

        Workspace result = togglApi.workspaces().getWorkspace(1624796);

        assertThat(result, notNullValue());
    }

    @SneakyThrows
    @Test
    public void workspacesGetUsers() {
        TogglApi togglApi = getTogglApi();

        List<User> resultList = togglApi.workspaces().getWorkspaceUsers(1624796);

        assertThat(resultList, notNullValue());
    }

    @SneakyThrows
    @Test
    public void workspacesGetClients() {
        TogglApi togglApi = getTogglApi();

        List<Client> resultList = togglApi.workspaces().getWorkspaceClients(1624796);

        assertThat(resultList, notNullValue());
    }

    @SneakyThrows
    @Test
    public void workspacesGetProjects() {
        TogglApi togglApi = getTogglApi();

        List<Project> resultList = togglApi.workspaces().getWorkspaceProjects(1624796);

        assertThat(resultList, notNullValue());
    }

    @SneakyThrows
    @Test
    public void workspacesGetTaks() {
        TogglApi togglApi = getTogglApi();

        List<Task> resultList = togglApi.workspaces().getWorkspaceTasks(1624796);

        assertThat(resultList, notNullValue());
    }

    @SneakyThrows
    @Test
    public void workspacesGetTags() {
        TogglApi togglApi = getTogglApi();

        List<Tag> resultList = togglApi.workspaces().getWorkspaceTags(1624796);

        assertThat(resultList, notNullValue());
    }

}
