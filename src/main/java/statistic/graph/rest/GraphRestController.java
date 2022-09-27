package statistic.graph.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import statistic.graph.GraphService;
import statistic.graph.GraphType;
import statistic.guests.GuestFilter;

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
        return service.getGraph(GraphType.fromString(request.getType()), getFilters(request));
    }

    private List<GuestFilter> getFilters(@RequestBody GraphRequestDto request) {
        return request.getFilters().stream()
                .map(s -> GuestFilter.builder()
                        .name(s)
                        .build())
                .collect(Collectors.toList());
    }

}


