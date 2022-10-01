package statistic.guests.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class GuestDto {
    private String name;
    private GuestParams params;
}
