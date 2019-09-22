package io.rocketbase.toggl.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

public enum RoundingType {
    ROUND_DOWN(-1),
    NEAREST(0),
    ROUND_UP(1);

    @Getter
    private int id;

    RoundingType(int id) {
        this.id = id;
    }

    @JsonCreator
    public static RoundingType findById(Integer id) {
        if (id != null) {
            for (RoundingType v : values()) {
                if (v.getId() == id.intValue()) {
                    return v;
                }
            }
        }
        return null;
    }


}
