package pl.project.instruktor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.project.instruktor.model.User;
import pl.project.instruktor.repository.RoleRepository;
import pl.project.instruktor.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;
    private final RoleRepository roleRepository;

    public LoginController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("")
    public String login(){
        return "login";
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User newUser = new User();
        newUser.setPassword("areczek");
        newUser.setUsername("areczek");
        newUser.setFirstName("areczek");
        newUser.setLastName("areczek");
        newUser.setEmail("areczek@areczek.pl");;
        userService.saveUser(newUser);
        return "Dodano";
    }

}
