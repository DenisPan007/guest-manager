package statistic.graph.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import statistic.graph.GraphService;
import statistic.graph.GraphType;

@RestController
@RequiredArgsConstructor
public class GraphRestController {
    @Autowired
    private GraphService service;

    @PostMapping
    @RequestMapping("/graph")
    public GraphResponseDto getGraph(@RequestBody GraphRequestDto request) {
        return service.getGraph(GraphType.fromString(request.getType()), request.getFilters());
    }


}


