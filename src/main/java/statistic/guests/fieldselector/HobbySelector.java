package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("хобби")
public class HobbySelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getHobby();
    }
}
