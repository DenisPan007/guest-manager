package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("предмет")
public class SubjectSelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getSchoolSubject();
    }
}
