package statistic.guests.filter.table;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;
import statistic.guests.filter.GuestFilter;

@Component("стол 5")
public class Table5Filter implements GuestFilter {

    @Override
    public boolean filter(GuestDto dto) {
        return Integer.valueOf(5).equals(dto.getParams().getTableNumber());
    }

    @Override
    public String getName() {
        return "стол 5";
    }

    @Override
    public String getGroup() {
        return "table";
    }
}
