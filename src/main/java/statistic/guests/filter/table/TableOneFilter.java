package statistic.guests.filter.table;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;
import statistic.guests.filter.GuestFilter;

@Component("стол 1")
public class TableOneFilter implements GuestFilter {

    @Override
    public boolean filter(GuestDto dto) {
        return Integer.valueOf(1).equals(dto.getParams().getTableNumber());
    }

    @Override
    public String getName() {
        return "стол 1";
    }

    @Override
    public String getGroup() {
        return "table";
    }
}
