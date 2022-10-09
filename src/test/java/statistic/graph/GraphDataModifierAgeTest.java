package statistic.graph;

import org.junit.jupiter.api.Test;
import statistic.graph.datamodifier.GraphDataModifierAge;
import statistic.graph.rest.GraphResponseDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class GraphDataModifierAgeTest {

    private GraphDataModifierAge modifierDate = new GraphDataModifierAge();

    @Test
    void modify() {
        var xArray = List.of("1", "4", "6");
        var yArray = List.of(10, 3, 1);

        var resp = new GraphResponseDto();
        resp.setXArray(xArray);
        resp.setYArray(yArray);

        var actualResult = modifierDate.modify(resp);

        var actualX = actualResult.getXArray();
        var actualY = actualResult.getYArray();

        assertEquals(6, actualX.size());

        assertArrayEquals(List.of(10,0,0,3,0,1).toArray(), actualY.toArray());
    }
}