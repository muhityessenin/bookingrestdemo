package kz.booking.bookingrestdemo.controllers;

import kz.booking.bookingrestdemo.models.Person;
import kz.booking.bookingrestdemo.repositories.PeopleRepository;
import kz.booking.bookingrestdemo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @Autowired
    private final PeopleRepository peopleRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/register/user")
    public Person registerUser(@RequestBody Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
       return peopleRepository.save(person);
    }

    @PostMapping("/users/unregister")
    public String unRegisterUser(Long id){
        userService.removeUser(id);
        return "home";
    }
}
