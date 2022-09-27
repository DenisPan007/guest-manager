package statistic.guests.fieldselector;

import statistic.guests.dto.GuestDto;

public interface GuestFieldSelector {
    String getField(GuestDto dto);
}