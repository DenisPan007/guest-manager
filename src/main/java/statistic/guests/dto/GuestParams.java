package statistic.guests.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @JsonProperty("subject")
    String schoolSubject;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    LocalDate birth;

    @JsonProperty("music")
    String musicType;

    String animal;

    String dish;

    String drink;

    String hobby;

    @JsonProperty("island")
    String islandSubject;

    String job;

    @JsonProperty("pets")
    String petsNumber;

    String superAbility;

    String randomNumber;

    public String getAge() {
        return String.valueOf(countAge(LocalDate.now().toEpochDay(), birth.toEpochDay()));
    }

    private long countAge(long dayEpochNow, long dayEpochBirth) {
        return Math.round(Math.floor((dayEpochNow - dayEpochBirth) / 365.25));
    }
}
