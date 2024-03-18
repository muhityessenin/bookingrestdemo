package kz.booking.bookingrestdemo.services;

import kz.booking.bookingrestdemo.models.Person;
import kz.booking.bookingrestdemo.repositories.PeopleRepository;
import kz.booking.bookingrestdemo.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;
    @Autowired
    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(username);

        if(person.isPresent()){
            var userobj = person.get();
            return User.builder().
                    username(userobj.getUsername()).
                    password(userobj.getPassword()).
                    roles(getRoles(userobj)).
                    build();
        }
        else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
    private String[] getRoles(Person person) {
        if(person.getRole() == null){
            return new String[]{"USER"};
        }
        return person.getRole().split(",");
    }
}
