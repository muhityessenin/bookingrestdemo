package kz.booking.bookingrestdemo.controllers;

import kz.booking.bookingrestdemo.models.User;
import kz.booking.bookingrestdemo.repositories.UserLoggingRepository;
import kz.booking.bookingrestdemo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserLoggingRepository userLoggingRepository;
    @GetMapping("/register")
    public String getRegisterPage(){
     return "sign-up";
    }
    @GetMapping("/login_page")
    public String getLoginPage(){
        return "login-page";
    }
    @PostMapping("/users/register")
    public String registerUser(User user){
        userService.createUser(user);
        return "redirect:/home/logged";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userLoggingRepository.findByUsernameAndPassword(username,password);
        if (user != null) {
            return "redirect:/home/logged";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login-page";
        }
    }
    @PostMapping("/users/unregister")
    public String unRegisterUser(Long id){
        userService.removeUser(id);
        return "home";
    }
}
