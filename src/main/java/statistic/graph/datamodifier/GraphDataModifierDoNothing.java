package statistic.graph.datamodifier;

import org.springframework.stereotype.Component;
import statistic.graph.rest.GraphResponseDto;

@Component("default")
public class GraphDataModifierDoNothing implements GraphDataModifier {
    @Override
    public GraphResponseDto modify(GraphResponseDto response) {
        return response;
    }
}