package statistic.guests.filter.table;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;
import statistic.guests.filter.GuestFilter;

@Component("стол 4")
public class Table4Filter implements GuestFilter {

    @Override
    public boolean filter(GuestDto dto) {
        return Integer.valueOf(4).equals(dto.getParams().getTableNumber());
    }

    @Override
    public String getName() {
        return "стол 4";
    }

    @Override
    public String getGroup() {
        return "table";
    }
}
