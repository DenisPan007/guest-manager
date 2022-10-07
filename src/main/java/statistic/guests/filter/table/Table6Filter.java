package statistic.guests.filter.table;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;
import statistic.guests.filter.GuestFilter;

@Component("стол 6")
public class Table6Filter implements GuestFilter {

    @Override
    public boolean filter(GuestDto dto) {
        return Integer.valueOf(6).equals(dto.getParams().getTableNumber());
    }

    @Override
    public String getName() {
        return "стол 6";
    }

    @Override
    public String getGroup() {
        return "table";
    }
}
