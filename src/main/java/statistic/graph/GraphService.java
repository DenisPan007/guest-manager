package statistic.graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import statistic.graph.rest.GraphResponseDto;
import statistic.guests.GuestFilter;
import statistic.guests.dto.GuestDto;
import statistic.guests.GuestMapper;
import statistic.guests.GuestRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GraphService {
    @Autowired
    private GraphCalculator calculator;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private GuestMapper mapper;

    public GraphResponseDto getGraph(GraphType type, List<GuestFilter> filters) {
        var guests = findGuests(filters);
        return calculator.calculate(guests, type);
    }

    private List<GuestDto> findGuests(List<GuestFilter> filters) {
        return guestRepository.findAll()
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());
    }
}
