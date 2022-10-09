package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("музыка")
public class MusicSelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getMusicType();
    }
}
