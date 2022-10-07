package statistic.guests.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestParams {
    @JsonProperty("color")
    String favoriteColor;

    @JsonProperty("movie")
    String movie;

    SexEnum sex;

    @JsonProperty("table")
    Integer tableNumber;

    @JsonProperty("subject")
    String schoolSubject;
}
