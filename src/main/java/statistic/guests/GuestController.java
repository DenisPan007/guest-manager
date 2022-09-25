package statistic.guests;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import statistic.guests.dto.GuestDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;

    @GetMapping("/")
    public String getDirectories(Model model) {
        List<GuestDto> guests = guestService.getAllGuests();
        model.addAttribute("guests", guests);
        return "index";
    }

}
