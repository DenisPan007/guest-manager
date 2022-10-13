package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("животные")
public class PetsNumberSelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getPetsNumber();
    }
}
