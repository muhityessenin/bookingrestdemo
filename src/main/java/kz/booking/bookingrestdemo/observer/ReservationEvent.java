package kz.booking.bookingrestdemo.observer;

import org.springframework.context.ApplicationEvent;

public class ReservationEvent extends ApplicationEvent {
    private String userEmail;
    private String message;

    public ReservationEvent(Object source, String userEmail, String message) {
        super(source);
        this.userEmail = userEmail;
        this.message = message;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getMessage() {
        return message;
    }
}
