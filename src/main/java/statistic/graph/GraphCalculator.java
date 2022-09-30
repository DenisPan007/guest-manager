package statistic.graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import statistic.graph.rest.GraphResponseDto;
import statistic.guests.fieldselector.GuestFieldSelector;
import statistic.guests.dto.GuestDto;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GraphCalculator {
    @Autowired
    private Map<String, GuestFieldSelector> functionsMap;

    public GraphResponseDto calculate(List<GuestDto> guests, GraphType type) {

        GuestFieldSelector guestDtoGuestFieldSelectorFunction = functionsMap.get(type.toString());
        var values = guests.stream()
        .map(guestDtoGuestFieldSelectorFunction::getField)
                .collect(Collectors.toList());
        var map = getAxisMap(values);

        var xArray = new ArrayList<>(map.keySet());
        var yArray = new ArrayList<>(map.values());

        GraphResponseDto graphResponseDto = new GraphResponseDto();
        graphResponseDto.setXArray(xArray);
        graphResponseDto.setYArray(yArray);
        graphResponseDto.setName(type.getTitle());
        return graphResponseDto;
    }

    private  Map<String, Integer> getAxisMap(List<String> values) {
        var map = new TreeMap<String, Integer>(Comparator.comparing(String::toString));

        values.forEach(k->map.merge(k, 1, Integer::sum));
        return map;
    }

}
