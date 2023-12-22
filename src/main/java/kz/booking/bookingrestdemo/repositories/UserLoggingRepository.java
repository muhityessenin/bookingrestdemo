package kz.booking.bookingrestdemo.repositories;

import kz.booking.bookingrestdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoggingRepository extends JpaRepository<User, String> {
    User findByUsernameAndPassword(String username, String password);
}
