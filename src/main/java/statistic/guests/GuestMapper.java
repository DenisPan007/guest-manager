package statistic.guests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;
import statistic.guests.dto.GuestEntity;
import statistic.guests.dto.GuestParams;

@Component
public class GuestMapper {

    private final ObjectMapper mapper = new ObjectMapper();

    public GuestDto map(GuestEntity entity){
        try {
            var params = mapper.readValue(entity.getParams(), GuestParams.class);
            return GuestDto.builder()
                    .name(entity.getName())
                    .params(params)
                    .build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
