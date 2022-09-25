package statistic.graph.rest;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class GraphRequestDto {
    private List<String> filters;
    private int _filters;
}
