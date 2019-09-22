package io.rocketbase.toggl.api.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataWrapper<T>{

    private T data;
}
