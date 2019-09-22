package io.rocketbase.toggl.api.resource;

import io.rocketbase.toggl.api.RequestContext;
import io.rocketbase.toggl.api.model.User;
import io.rocketbase.toggl.api.util.DataWrapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

@RequiredArgsConstructor
public class UserResource {

    private final RequestContext requestContext;

    @SneakyThrows
    public User getMe() {
        DataWrapper<User> wrapper = requestContext.execute(requestContext.getUriBuilder().path("/me"),
                HttpMethod.GET, new ParameterizedTypeReference<DataWrapper<User>>() {
                });
        return wrapper.getData();
    }

}
