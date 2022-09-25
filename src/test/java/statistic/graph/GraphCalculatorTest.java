package statistic.graph;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import statistic.guests.dto.GuestDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
class GraphCalculatorTest {
    @Autowired
    private GraphCalculator calculator;

    @Test
    void calculate() {
        var g1 = GuestDto.builder()
                .name("Alena")
                .favoriteColor("white")
                .build();
        var g2 = GuestDto.builder()
                .name("Denis")
                .favoriteColor("blue")
                .build();
        var g3 = GuestDto.builder()
                .name("Roma")
                .favoriteColor("blue")
                .build();
        var g4 = GuestDto.builder()
                .name("Dima")
                .favoriteColor("black")
                .build();

        var expectedXArray = new ArrayList<>(List.of("black", "blue", "white"));
        var expectedYArray = List.of(1, 2, 1);
        var res = calculator.calculate(List.of(g1, g2, g3, g4), GraphType.Color);

        assertArrayEquals(expectedXArray.toArray(), res.getXArray().toArray());
        assertArrayEquals(expectedYArray.toArray(), res.getYArray().toArray());

    }
}