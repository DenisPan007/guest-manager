package statistic.guests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import statistic.guests.dto.GuestEntity;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Long> {
}
