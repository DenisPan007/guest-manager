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
        var allGuests = guestRepository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());

        var filteredGuests = findGuests(getFilters(filterNames), allGuests);
        return calculator.calculate(filteredGuests, type);
    }

    List<GuestFilter> getFilters(List<String> filterNames) {
        return filterNames.stream()
                .map(guestFilterMap::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
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

    private List<GuestDto> filterWithinOneGroup(List<GuestFilter> filters, List<GuestDto> allGuests) {
        List<GuestDto> filteredGuests = new ArrayList<>();

        filters.forEach((f) -> filteredGuests.addAll(allGuests.stream()
                .filter(f::filter)
                .collect(Collectors.toList())));
        return filteredGuests;
    }
}
