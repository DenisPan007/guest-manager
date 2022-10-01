package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("color")
public class GuestColorSelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getFavoriteColor();
    }
}
