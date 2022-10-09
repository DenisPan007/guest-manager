package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("возраст")
public class AgeSelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getAge();
    }
}
