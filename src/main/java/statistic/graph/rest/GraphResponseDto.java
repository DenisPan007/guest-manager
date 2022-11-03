package statistic.graph.rest;

import lombok.Getter;
import lombok.Setter;
import statistic.guests.dto.GuestDto;

import java.util.List;

@Getter
@Setter
public class GraphResponseDto {
    private String name = "Ты не должен видеть этот тескт в браузере";
    private List<String> xArray;
    private List<Integer> yArray;
    private List<GuestDto> guests;
    private String label;

}
