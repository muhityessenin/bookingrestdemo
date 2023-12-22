package kz.booking.bookingrestdemo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    @Id
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservation_id;
    @Column(name = "restaurant_id")
    private Long restaurant_id;
    @Column(name = "restaurant_name")
    private String restaurant_name;
    @Column(name = "user_email")
    private String user_email;
    @Column(name = "reservation_date")
    private LocalDateTime reservationDateTime;
    @Column(name = "people")
    private int people_for_reservation;
    public static class ReservationBuilder {
        private Long reservation_id;
        private Long restaurant_id;
        private String restaurant_name;
        private String user_email;
        private LocalDateTime reservationDateTime;
        private int people_for_reservation;
        public ReservationBuilder() {
        }
        public ReservationBuilder restaurantName(String restaurantName) {
            this.restaurant_name = restaurantName;
            return this;
        }
        public ReservationBuilder people_for_reservation(int people_for_reservation) {
            this.people_for_reservation=people_for_reservation;
            return this;
        }
        public ReservationBuilder reservationDateTime(LocalDateTime reservationDateTime) {
            this.reservationDateTime=reservationDateTime;
            return this;
        }
        public ReservationBuilder user_email(String user_email){
            this.user_email=user_email;
            return this;
        }


        public Reservation build() {
            Reservation reservation = new Reservation();
            reservation.setRestaurant_name(this.restaurant_name);
            reservation.setPeople_for_reservation(this.people_for_reservation);
            reservation.setReservationDateTime(this.reservationDateTime);
            reservation.setUser_email(this.user_email);

            return reservation;
        }
    }
}
