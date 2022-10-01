package statistic.graph;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import statistic.guests.dto.GuestDto;
import statistic.guests.dto.GuestParams;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
class GraphCalculatorTest {
    @Autowired
    private GraphCalculator calculator;

    @Test
    void calculate() {
        var g1 = buildGuestWithColor("Alena", "white");
        var g2 = buildGuestWithColor("Denis", "blue");
        var g3 = buildGuestWithColor("Roma", "blue");
        var g4 = buildGuestWithColor("Dima", "black");

        var expectedXArray = new ArrayList<>(List.of("black", "blue", "white"));
        var expectedYArray = List.of(1, 2, 1);
        var res = calculator.calculate(List.of(g1, g2, g3, g4), GraphType.Color);

        assertArrayEquals(expectedXArray.toArray(), res.getXArray().toArray());
        assertArrayEquals(expectedYArray.toArray(), res.getYArray().toArray());

    }

    private GuestDto buildGuestWithColor(String name, String color) {
        return GuestDto.builder()
                .name(name)
                .params(GuestParams.builder()
                .favoriteColor(color)
                .build())
                .build();
    }
}