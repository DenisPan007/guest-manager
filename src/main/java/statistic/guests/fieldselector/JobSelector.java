package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("профессия")
public class JobSelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getJob();
    }
}
