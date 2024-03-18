package kz.booking.bookingrestdemo.controllers;

import kz.booking.bookingrestdemo.config.Config;
import kz.booking.bookingrestdemo.models.Reservation;
import kz.booking.bookingrestdemo.observer.EmailSubscriber;
import kz.booking.bookingrestdemo.observer.ReservationEvent;
import kz.booking.bookingrestdemo.observer.ReservationNotifier;
import kz.booking.bookingrestdemo.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    @Autowired
    private ReservationNotifier reservationNotifier;
    @GetMapping("/mybookings/")
    public String getAllBookings(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("reservations", reservationService.getAllBookings(name));
        return "bookings";
    }
    @GetMapping("/reservation/{reservation_id}")
    public String bookingInfo(@PathVariable Long reservation_id, Model model){
        Reservation reservation = reservationService.getBookingByID(reservation_id);
        model.addAttribute("reservation",reservation);
        return "reservation-info";
    }
    @PostMapping("/reservation/reserve")
    public String addBooking(@ModelAttribute Reservation reservation){
        Reservation newReservation = new Reservation.ReservationBuilder()
                .restaurantName(reservation.getRestaurant_name())
                .people_for_reservation(reservation.getPeople_for_reservation())
                .reservationDateTime(reservation.getReservationDateTime())
                .user_email(reservation.getUser_email())
                .build();
        reservationNotifier.subscribe(new EmailSubscriber(new Config()));
        reservationNotifier.onApplicationEvent(new ReservationEvent(this, reservation.getUser_email(), "Your table is reserved at "+ reservation.getReservationDateTime().toString()
                        + " in "+ reservation.getRestaurant_name() + " for " + reservation.getPeople_for_reservation() + " people"));
        reservationService.addBooking(newReservation);
        return "home";
    }
    @PostMapping("/reservation/cancel/{reservation_id}")
    public String cancelBooking(@PathVariable Long reservation_id){
        reservationService.cancelBooking(reservation_id);
        return "home";
    }
}
