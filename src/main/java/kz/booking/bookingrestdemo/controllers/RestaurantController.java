package kz.booking.bookingrestdemo.controllers;

import kz.booking.bookingrestdemo.models.Restaurant;
import kz.booking.bookingrestdemo.services.RestaurantService;
import kz.booking.bookingrestdemo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;
    private final UserService userService;
    @GetMapping("/user/home")
    public String restaurant(@RequestParam(name = "name", required = false)String name,  Model model){
        model.addAttribute("restaurants",restaurantService.getAllRestaurants(name));
    return "home";
    }
    @GetMapping("/admin/home")
    public String restaurants(@RequestParam(name = "name", required = false)String name,  Model model){
        model.addAttribute("restaurants",restaurantService.getAllRestaurants(name));
        return "admin";
    }
    @GetMapping("/user/restaurant/{restaurant_id}")
    public String restaurantInfo(@PathVariable Long restaurant_id, Model model){
        Restaurant restaurant = restaurantService.getRestaurantById(restaurant_id);
        model.addAttribute("restaurant",restaurant);
        model.addAttribute("images",restaurant.getImages());
        return "restaurant-info";
    }
    @PostMapping("/user/restaurant/create")
    public String createRestaurant(@RequestParam("file1")MultipartFile file1,@RequestParam("file2")MultipartFile file2,
                                   @RequestParam("file3")MultipartFile file3, Restaurant restaurant) throws IOException{
        restaurantService.createRestaurant(restaurant,file1,file2,file3);
        return "home";
    }
    @PostMapping("/user/restaurant/delete/{id}")
    public String deleteRestaurant(@PathVariable Long id){
        restaurantService.removeRestaurantById(id);
        return "home";
    }

}
