package statistic.guests.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SexEnum {
    Male("мужчина"),
    Female("женщина");

    private final String value;

    SexEnum(String value) {
        this.value = value;
    }

    @JsonCreator
    public static SexEnum fromString(String text) {
        for (SexEnum b : SexEnum.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new RuntimeException("There isn't enum of value: " + text);
    }

    @Override
    @JsonValue
    public String toString() {
        return value;
    }
}
