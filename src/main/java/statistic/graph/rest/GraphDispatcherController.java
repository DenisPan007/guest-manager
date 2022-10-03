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

@Controller
@RequiredArgsConstructor
public class GraphDispatcherController {
    @Autowired
    List<GuestFilter> filters;

    @GetMapping
    @RequestMapping("/stat")
    public String getGraph(Model model) {
        model.addAttribute("filters", filters);
        model.addAttribute("types", getTypes());

        model.addAttribute("payload", new GraphRequestDto());

        return "stat";
    }

    private List<String> getTypes() {
        return List.of(GraphType.Color.toString(), GraphType.Name.toString());
    }
}



