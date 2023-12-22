package kz.booking.bookingrestdemo.repositories;

import kz.booking.bookingrestdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}