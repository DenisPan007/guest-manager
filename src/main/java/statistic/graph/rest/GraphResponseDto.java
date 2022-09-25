package statistic.graph.rest;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GraphResponseDto {
    private String name = "TestResponse";
    private List<String> xArray;
    private List<Integer> yArray;

}
