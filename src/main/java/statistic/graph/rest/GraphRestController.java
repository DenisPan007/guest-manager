package statistic.graph.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import statistic.graph.GraphService;

@RestController
@RequiredArgsConstructor
public class GraphRestController {
    @Autowired
    private GraphService service;

    @GetMapping
    @RequestMapping("/graph")
    public GraphResponseDto getGraph(@RequestParam("text") String param) {
        return service.getGraph();
    }

}


