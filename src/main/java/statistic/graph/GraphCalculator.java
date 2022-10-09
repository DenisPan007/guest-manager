package statistic.graph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import statistic.graph.datamodifier.GraphDataModifier;
import statistic.graph.datamodifier.GraphDataModifierDoNothing;
import statistic.graph.rest.GraphResponseDto;
import statistic.guests.fieldselector.GuestFieldSelector;
import statistic.guests.dto.GuestDto;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GraphCalculator {
    @Autowired
    private Map<String, GuestFieldSelector> fieldSelectorsMap;

    @Autowired
    private Map<String, GraphDataModifier> responseModifiersMap;

    public GraphResponseDto calculate(List<GuestDto> guests, GraphType type) {

        GuestFieldSelector guestDtoGuestFieldSelector = fieldSelectorsMap.get(type.toString());
        var modifier = responseModifiersMap.getOrDefault(type.toString() + "-мод",new GraphDataModifierDoNothing());

        var values = getValues(guests, guestDtoGuestFieldSelector);
        var map = getAxisMap(values);

        var xArray = new ArrayList<>(map.keySet());
        var yArray = new ArrayList<>(map.values());

        GraphResponseDto graphResponseDto = new GraphResponseDto();
        graphResponseDto.setXArray(xArray);
        graphResponseDto.setYArray(yArray);
        graphResponseDto.setName(type.getTitle());
        return modifier.modify(graphResponseDto);
    }

    private List<String> getValues(List<GuestDto> guests, GuestFieldSelector guestDtoGuestFieldSelector) {
        return guests.stream()
        .map(guestDtoGuestFieldSelector::getField)
                .collect(Collectors.toList());
    }

    private  Map<String, Integer> getAxisMap(List<String> values) {
        var map = new TreeMap<String, Integer>(Comparator.comparing(String::toString));

        values.forEach(k->map.merge(k, 1, Integer::sum));
        return map;
    }

}
