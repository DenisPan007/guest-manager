package statistic.guests.filter;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;
import statistic.guests.dto.SexEnum;

@Component("мужчины")
public class MaleFilter implements GuestFilter {

    @Override
    public boolean filter(GuestDto dto) {
        return SexEnum.Male.equals(dto.getParams().getSex());
    }

    @Override
    public String getName() {
        return "мужчины";
    }

    @Override
    public String getGroup() {
        return "sex";
    }
}
