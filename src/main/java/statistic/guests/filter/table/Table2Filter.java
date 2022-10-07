package statistic.guests.filter.table;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;
import statistic.guests.filter.GuestFilter;

@Component("стол 2")
public class Table2Filter implements GuestFilter {

    @Override
    public boolean filter(GuestDto dto) {
        return Integer.valueOf(2).equals(dto.getParams().getTableNumber());
    }

    @Override
    public String getName() {
        return "стол 2";
    }

    @Override
    public String getGroup() {
        return "table";
    }
}
