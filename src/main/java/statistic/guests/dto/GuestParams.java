package statistic.guests.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

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
}
