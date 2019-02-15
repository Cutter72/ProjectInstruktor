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


    @GetMapping("/register")
    public String addUser(@ModelAttribute User user) {
        return "register";
    }

    @PostMapping("/register")
    public String addUserSuccess(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userServiceImpl.saveUser(user);
        return "redirect:/login";
    }

}
