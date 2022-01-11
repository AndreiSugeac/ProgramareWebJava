package extremeworld.repository;

import extremeworld.domain.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Modifying
    @Query(value = "DELETE FROM reservations WHERE id = :id", nativeQuery = true)
    void deleteReservation(Long id);

    @Modifying
    @Query(value = "DELETE FROM reservations_users WHERE id = :id", nativeQuery = true)
    void deleteReservationUser(Long id);

    @Modifying
    @Query(value = "DELETE FROM reservations_activities WHERE id = :id", nativeQuery = true)
    void deleteReservationActivity(Long id);
}
