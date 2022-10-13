package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("остров")
public class IslandSubjectSelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getIslandSubject();
    }
}
