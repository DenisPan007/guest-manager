package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("животное")
public class AnimalSelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getAnimal();
    }
}
