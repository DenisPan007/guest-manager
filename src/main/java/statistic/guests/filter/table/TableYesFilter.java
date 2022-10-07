package statistic.guests.filter.table;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;
import statistic.guests.filter.GuestFilter;

@Component("стол да")
public class TableYesFilter implements GuestFilter {

    @Override
    public boolean filter(GuestDto dto) {
        return Integer.valueOf(0).equals(dto.getParams().getTableNumber());
    }

    @Override
    public String getName() {
        return "стол да";
    }

    @Override
    public String getGroup() {
        return "table";
    }
}
