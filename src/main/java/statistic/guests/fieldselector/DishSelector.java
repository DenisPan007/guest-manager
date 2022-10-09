package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("блюдо")
public class DishSelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getDish();
    }
}
