package io.rocketbase.toggl.api.resource;

import io.rocketbase.toggl.api.RequestContext;
import io.rocketbase.toggl.api.model.Client;
import io.rocketbase.toggl.api.model.Project;
import io.rocketbase.toggl.api.util.DataWrapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import java.util.List;

@RequiredArgsConstructor
public class ClientResource {

    private final RequestContext requestContext;

    @SneakyThrows
    public Client getClient(long clientId) {
        DataWrapper<Client> wrapper = requestContext.execute(requestContext.getUriBuilder().path("/clients").path("/" + clientId),
                HttpMethod.GET, new ParameterizedTypeReference<DataWrapper<Client>>() {
                });
        return wrapper.getData();
    }

    @SneakyThrows
    public List<Project> getClientProjects(long clientId) {
        return requestContext.execute(requestContext.getUriBuilder().path("/clients").path("/" + clientId).path("/projects"),
                HttpMethod.GET, new ParameterizedTypeReference<List<Project>>() {
                });
    }

}
