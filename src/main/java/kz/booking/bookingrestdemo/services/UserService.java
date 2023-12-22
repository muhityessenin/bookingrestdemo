package kz.booking.bookingrestdemo.services;

import kz.booking.bookingrestdemo.models.User;
import kz.booking.bookingrestdemo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
   private final UserRepository userRepository;
   public User findByUserName(String name){
      return userRepository.findByUsername(name);
   }
   public void createUser(User user){
       userRepository.save(user);
   }
   public void removeUser(Long user_id){
       userRepository.deleteById(user_id);
   }

}
