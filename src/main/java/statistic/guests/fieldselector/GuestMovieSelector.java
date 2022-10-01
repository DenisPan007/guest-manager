package statistic.guests.fieldselector;

import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

@Component("movie")
public class GuestMovieSelector implements GuestFieldSelector {
    public String getField(GuestDto dto){
        return dto.getParams().getMovie();
    }
}
