package statistic.graph.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import statistic.graph.GraphService;
import statistic.graph.GraphType;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class GraphRestController {
    @Autowired
    private GraphService service;

    @PostMapping
    @RequestMapping("/graph")
    public GraphResponseDto getGraph(@RequestBody GraphRequestDto request) {
        GraphResponseDto graph = service.getGraph(GraphType.fromString(request.getType()), request.getFilters());
        graph.setLabel(buildLAbelByFilters(request.getFilters()));
        return graph;
    }

    private String buildLAbelByFilters(List<String> filters){
       return String.join(", ", filters);
    }


}


