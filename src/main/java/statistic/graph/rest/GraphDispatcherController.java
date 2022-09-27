package statistic.graph.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import statistic.graph.GraphType;
import statistic.guests.GuestFilter;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GraphDispatcherController {

    @GetMapping
    @RequestMapping("/stat")
    public String getGraph(Model model) {
        model.addAttribute("filters", getFilters());
        model.addAttribute("types", getTypes());

        model.addAttribute("payload", new GraphRequestDto());

        return "stat";
    }

    private List<GuestFilter> getFilters() {
        var filter1 = GuestFilter.builder()
                .name("filter1")
                .build();
        var filter2 = GuestFilter.builder()
                .name("filter2")
                .build();
        return List.of(filter1, filter2);
    }

    private List<String> getTypes() {
        return List.of(GraphType.Color.toString(), GraphType.Name.toString());
    }
}



