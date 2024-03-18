package kz.booking.bookingrestdemo.services;

import kz.booking.bookingrestdemo.models.Person;

import kz.booking.bookingrestdemo.repositories.PeopleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    @Autowired
   private final PeopleRepository personRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
   public Optional<Person> findByUserName(String name){
      return personRepository.findByUsername(name);
   }
   public void createUser(Person user){
       passwordEncoder.encode(user.getPassword());
       personRepository.save(user);
   }
   public void removeUser(Long user_id){
       personRepository.deleteById(user_id);
   }

}
