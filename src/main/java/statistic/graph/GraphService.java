package statistic.graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import statistic.graph.rest.GraphResponseDto;
import statistic.guests.filter.GuestFilter;
import statistic.guests.dto.GuestDto;
import statistic.guests.GuestMapper;
import statistic.guests.GuestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GraphService {
    @Autowired
    private GraphCalculator calculator;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private Map<String, GuestFilter> guestFilterMap;

    @Autowired
    private GuestMapper mapper;

    public GraphResponseDto getGraph(GraphType type, List<String> filterNames) {
        List<GuestDto> filteredGuests = findGuests(filterNames);
        GraphResponseDto res = calculator.calculate(filteredGuests, type);
        res.setGuests(filteredGuests);
        return res;
    }

    private List<GuestDto> findGuests(List<String> filterNames) {
        var allGuests = guestRepository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());

        return findGuests(getFilters(filterNames), allGuests);
    }

    List<GuestDto> findGuests(List<GuestFilter> filters, List<GuestDto> allGuests) {
        var gropedFilters = filters.stream()
                .collect(Collectors.groupingBy(GuestFilter::getGroup));

        List<List<GuestFilter>> filtersByGroups = new ArrayList<>(gropedFilters.values());

        var filteredGuestsTemp = allGuests;

        for (List<GuestFilter> filterGroup : filtersByGroups) {
            filteredGuestsTemp = filterWithinOneGroup(filterGroup, filteredGuestsTemp);
        }

        return filteredGuestsTemp;
    }

    List<GuestFilter> getFilters(List<String> filterNames) {
        return filterNames.stream()
                .map(guestFilterMap::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private List<GuestDto> filterWithinOneGroup(List<GuestFilter> filters, List<GuestDto> allGuests) {
        List<GuestDto> filteredGuests = new ArrayList<>();

        filters.forEach((f) -> filteredGuests.addAll(allGuests.stream()
                .filter(f::filter)
                .collect(Collectors.toList())));
        return filteredGuests;
    }
}
