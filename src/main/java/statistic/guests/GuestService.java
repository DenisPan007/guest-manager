package statistic.guests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import statistic.guests.dto.GuestDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<GuestDto> getAllGuests(){
        return guestRepository.findAll().stream()
                .map(entity-> GuestDto.builder().name(entity.getName()).build())
                .collect(Collectors.toList());
    }
}
