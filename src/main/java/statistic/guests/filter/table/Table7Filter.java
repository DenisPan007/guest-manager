package statistic.guests.filter.table;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;
import statistic.guests.filter.GuestFilter;

@Component("стол 7")
public class Table7Filter implements GuestFilter {

    @Override
    public boolean filter(GuestDto dto) {
        return Integer.valueOf(7).equals(dto.getParams().getTableNumber());
    }

    @Override
    public String getName() {
        return "стол 7";
    }

    @Override
    public String getGroup() {
        return "table";
    }
}
