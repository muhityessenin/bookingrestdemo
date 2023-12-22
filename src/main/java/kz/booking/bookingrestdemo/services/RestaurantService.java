package kz.booking.bookingrestdemo.services;

import kz.booking.bookingrestdemo.models.Image;
import kz.booking.bookingrestdemo.models.Restaurant;
import kz.booking.bookingrestdemo.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    public List<Restaurant> getAllRestaurants(String name){
        if(name!=null) return restaurantRepository.findByName(name);
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id){
        return restaurantRepository.findById(id).orElse(null);
    }
    public void createRestaurant(Restaurant restaurant, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException,IndexOutOfBoundsException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            restaurant.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            restaurant.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            restaurant.addImageToProduct(image3);
        }
        log.info("Saving new Restaurant. Title: {}; Author: {}", restaurant.getName(),restaurant.getName());
        Restaurant restaurantFromDb = restaurantRepository.save(restaurant);
        restaurantFromDb.setPreviewImageID(restaurantFromDb.getImages().get(0).getId());
        restaurantRepository.save(restaurant);
    }
    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }
    public void removeRestaurantById(Long id){
        restaurantRepository.deleteById(id);
    }
}
