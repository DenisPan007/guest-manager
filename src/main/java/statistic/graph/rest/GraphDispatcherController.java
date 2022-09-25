package statistic.graph.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import statistic.guests.GuestFilter;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GraphDispatcherController {

    @GetMapping
    @RequestMapping("/stat")
    public String getGraph(Model model) {
        var filter1 = new GuestFilter();
        filter1.setName("first filter");
        var filter2 = new GuestFilter();
        filter2.setName("second filter");
        model.addAttribute("filters", List.of(filter1, filter2));
        model.addAttribute("payload", new GraphRequestDto());

        return "stat";
    }
}



