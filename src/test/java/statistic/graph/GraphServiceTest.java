package statistic.graph;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import statistic.guests.filter.FemaleFilter;
import statistic.guests.filter.MaleFilter;
import statistic.guests.dto.GuestDto;
import statistic.guests.dto.GuestParams;
import statistic.guests.filter.TableOneFilter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GraphServiceTest {

    @Autowired
    private GraphService service;

    @Test
    void sexFilterTest() {
        var maleFilter = new MaleFilter();
        var femaleFilter = new FemaleFilter();

        var g1 = getTestSexFilterGuest("g1", "male");
        var g2 = getTestSexFilterGuest("g2", "male");
        var g3 = getTestSexFilterGuest("g3", "female");
        var g4 = getTestSexFilterGuest("g4", "female");
        var g5 = getTestSexFilterGuest("g5", "female");

        var guests = List.of(g1, g2, g3, g4, g5);

        var filteredFemale = service.findGuests(List.of(femaleFilter), guests);
        var filteredMale = service.findGuests(List.of(maleFilter), guests);
        var filteredMaleAndFemale = service.findGuests(List.of(maleFilter, femaleFilter), guests);

        assertEquals(3, filteredFemale.size());
        assertEquals(2, filteredMale.size());
        assertEquals(5, filteredMaleAndFemale.size());
    }

    @Test
    void crossFilterTest() {
        var maleFilter = new MaleFilter();
        var femaleFilter = new FemaleFilter();
        var table1Filter = new TableOneFilter();

        var g1 = getTestCrossFilterGuest("g1", "male", 1);
        var g2 = getTestCrossFilterGuest("g2", "male", 1);
        var g3 = getTestCrossFilterGuest("g3", "female", 1);
        var g4 = getTestCrossFilterGuest("g4", "female", 3);
        var g5 = getTestCrossFilterGuest("g5", "female", 4);

        var guests = List.of(g1, g2, g3, g4, g5);

        var filteredFemaleTable1 = service.findGuests(List.of(femaleFilter,table1Filter), guests);
        var filteredMaleTable1 = service.findGuests(List.of(maleFilter,table1Filter), guests);
        var filteredAll = service.findGuests(List.of(maleFilter, femaleFilter, table1Filter), guests);

        assertEquals(1, filteredFemaleTable1.size());
        assertEquals(2, filteredMaleTable1.size());
        assertEquals(3, filteredAll.size());
    }

    private GuestDto getTestSexFilterGuest(String name, String sex) {
        return GuestDto.builder()
                .name(name)
                .params(GuestParams.builder()
                        .sex(sex)
                        .build())
                .build();
    }

    private GuestDto getTestCrossFilterGuest(String name, String sex, Integer table) {
        return GuestDto.builder()
                .name(name)
                .params(GuestParams.builder()
                        .sex(sex)
                        .tableNumber(table)
                        .build())
                .build();
    }
}