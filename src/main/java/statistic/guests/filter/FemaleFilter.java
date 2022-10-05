package statistic.guests.filter;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;
import statistic.guests.dto.SexEnum;

@Component("женщины")
public class FemaleFilter implements GuestFilter {

    @Override
    public boolean filter(GuestDto dto) {
        return SexEnum.Female.equals(dto.getParams().getSex());
    }

    @Override
    public String getName() {
        return "женщины";
    }

    @Override
    public String getGroup() {
        return "sex";
    }
}
