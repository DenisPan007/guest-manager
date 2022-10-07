package statistic.graph.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import statistic.graph.GraphType;
import statistic.guests.filter.GuestFilter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class GraphDispatcherController {
    @Autowired
    List<GuestFilter> filters;

    @GetMapping
    @RequestMapping("/")
    public String getGraph(Model model) {
        model.addAttribute("filters", filters);
        model.addAttribute("types", getTypes());

        model.addAttribute("payload", new GraphRequestDto());

        return "index";
    }

    private List<String> getTypes() {
        return Stream.of(GraphType.values())
                .map(GraphType::toString)
                .collect(Collectors.toList());
    }
}



