package kz.booking.bookingrestdemo.repositories;

import kz.booking.bookingrestdemo.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
