package statistic.guests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
