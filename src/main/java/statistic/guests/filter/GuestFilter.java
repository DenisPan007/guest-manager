package statistic.guests.filter;

import statistic.guests.dto.GuestDto;

public interface GuestFilter {

    boolean filter(GuestDto dto);

    String getName();

    String getGroup();
}
