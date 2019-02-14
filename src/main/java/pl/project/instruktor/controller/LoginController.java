package pl.project.instruktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.project.instruktor.model.User;

import pl.project.instruktor.repository.UserRepository;
import pl.project.instruktor.service.UserService;
import pl.project.instruktor.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final UserServiceImpl userServiceImpl;

    public LoginController(UserService userService, UserRepository userRepository, UserServiceImpl userServiceImpl) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("")
    public String login(){
        return "login";
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User newUser = new User();
        newUser.setPassword("user");
        newUser.setUsername("user");
        newUser.setFirstName("Jan");
        newUser.setLastName("Kowalski");
        newUser.setEmail("janek.kowalski@gmail.pl");

        userService.saveUser(newUser);
        return "Dodano";
    }

    @GetMapping("/add")
    public String addUser(@ModelAttribute User user) {

        return "userAdd";
    }

    @PostMapping("/add")
    public String addUserSuccess(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "userAdd";
        }
        userServiceImpl.saveUser(user);
        return "redirect:/login";
    }

}
