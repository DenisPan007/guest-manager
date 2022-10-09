package statistic.graph.datamodifier;

import org.springframework.stereotype.Component;
import statistic.graph.rest.GraphResponseDto;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component("возраст-мод")
public class GraphDataModifierAge implements GraphDataModifier {
    @Override
    public GraphResponseDto modify(GraphResponseDto response) {

        var xArrayInt = response.getXArray().stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        if (xArrayInt.isEmpty()) {
            return response;
        }
        var minAge = xArrayInt.stream()
                .min(Integer::compareTo)
                .get();

        var maxAge = xArrayInt.stream()
                .max(Integer::compareTo)
                .get();

        var newXArray = IntStream.range(minAge, maxAge + 1)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.toList());

        var newYArray = newXArray.stream()
                .map(el -> {
                    int index = xArrayInt.indexOf(Integer.valueOf(el));
                    if (index != -1){
                        return response.getYArray().get(index);
                    }
                    else{
                        return 0;
                    }
                })
                .collect(Collectors.toList());
        response.setXArray(newXArray);
        response.setYArray(newYArray);
        return response;
    }
}
