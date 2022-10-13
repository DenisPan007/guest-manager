package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("число")
public class RandomNumberSelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getRandomNumber();
    }
}
