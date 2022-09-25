package statistic.guests.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GuestParams {
    @JsonProperty("color")
    String favoriteColor;
}
