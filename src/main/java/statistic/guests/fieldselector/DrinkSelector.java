package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("напиток")
public class DrinkSelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getDrink();
    }
}
