package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("способность")
public class SuperAbilitySelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getSuperAbility();
    }
}
