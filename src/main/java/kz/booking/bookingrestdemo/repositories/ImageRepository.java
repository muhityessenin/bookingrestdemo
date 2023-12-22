package kz.booking.bookingrestdemo.repositories;

import kz.booking.bookingrestdemo.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
