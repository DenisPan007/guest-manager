package statistic.graph.datamodifier;

import statistic.graph.rest.GraphResponseDto;

public interface GraphDataModifier {

    GraphResponseDto modify(GraphResponseDto response);
}
