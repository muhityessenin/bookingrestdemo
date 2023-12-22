package kz.booking.bookingrestdemo.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationNotifier implements ApplicationListener<ReservationEvent> {

    private List<EmailSubscriber> subscribers = new ArrayList<>();

    public void subscribe(EmailSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(EmailSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void onApplicationEvent(ReservationEvent event) {
        notifySubscribers(event.getUserEmail(), event.getMessage());
    }

    private void notifySubscribers(String userEmail, String message) {
        for (EmailSubscriber subscriber : subscribers) {
            subscriber.update(userEmail, message);
        }
    }
}
