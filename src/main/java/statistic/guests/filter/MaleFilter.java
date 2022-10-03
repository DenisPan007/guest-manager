package statistic.guests.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("мужчины")
public class MaleFilter implements GuestFilter {

    @Override
    public boolean filter(GuestDto dto) {
        return "male".equals(dto.getParams().getSex());
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
